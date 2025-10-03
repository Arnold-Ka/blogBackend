package com.hackers.blogbackend.service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hackers.blogbackend.entity.Post;
import com.hackers.blogbackend.entity.enom.EStatut;
import com.hackers.blogbackend.service.interfaces.PostServiceInterface;
import com.hackers.blogbackend.utils.Utils;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackers.blogbackend.dto.PostDto;
import com.hackers.blogbackend.dto.postdto.PostCreateDto;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.CategoryRepository;
import com.hackers.blogbackend.repository.PostRepository;
import com.hackers.blogbackend.repository.TagRepository;
import com.hackers.blogbackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements PostServiceInterface {
    PostRepository postRepository;
    TagRepository tagRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    BlMapper mapper = Mappers.getMapper(BlMapper.class);
    private static final int V = 250;

    /**
     * Recuperation de touts les posts.
     * @return la liste de tout les posts
     */
    @Transactional
    public List<PostDto> getPost(){
        return postRepository.findAllActive().stream()
                            .map(mapper::maps)
                            .collect(Collectors.toList());
    }

    /**
     * Recuperation d'un post.
     * @id l'identifiant du post
     * @return  le Post si trouvé, ou vide si non trouvé
     */
    @Transactional
    public Optional<PostDto> getPostById(final String id) {
        return postRepository.findByIdAndStatut(id, EStatut.ACTIVE)
                             .map(mapper::maps);
    }

    /**
     * 
     * @param date
     * @return
     */
    public List<PostDto> getPostByDate(Instant date) {
        return postRepository.findByCreatedAt(date)
                                                    .stream()
                                                    .map(mapper::maps)
                                                    .toList();
    }
    /**
     * Ajouter un nouveau Post.
     * @param postDto le contenu du post a ajouter
     * @return le post enregistrer
     */
    @Transactional
    public PostDto doPostPost(final PostCreateDto postCreateDto){
        Post post = mapper.maps(postCreateDto);
        String baseSlug = postCreateDto.getTitle();
        List<String> slugs = postRepository.findBySlugLike(baseSlug);
        post.setSlug(Utils.generateUniqueSlug(postCreateDto.getTitle(), slugs));
        post.setTags(postCreateDto.getTags().stream()
                                            .map(name ->tagRepository
                                            .findByName(name).orElse(null))
                                            .filter(Objects::nonNull)
                                            .collect(Collectors.toSet()));
        post.setUser(userRepository.findByIdAndStatut(postCreateDto.getUserId(),EStatut.ACTIVE).orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé")));
        post.setCategory(categoryRepository.findByIdAndStatut(postCreateDto.getCategoryId(),EStatut.ACTIVE).orElseThrow(() -> new IllegalArgumentException("Category non trouvé")));
        post.setEstimateTimeToRead(Utils.tempsLecture(postCreateDto.getContent(), V));
        postRepository.save(post);

        return mapper.maps(post);
    }

    /**
     * Mise a jour d'un post
     * @param id l'identifient du post
     * @param postDto les modification du post
     * @return le post modifier
     */
    @Transactional
    public PostDto doUpdatePost(final String id,final PostCreateDto postCreateDto){
        Post post = mapper.maps(postCreateDto);
        post.setId(id);
        return mapper.maps(postRepository.save(post));
    }

    /**
     * Suppressiond d'un post a travers son id
     * @param id m'id du post a supprimer
     */
    @Transactional
    public void doDeletePost(final String id){
        postRepository.deleteById(id);
    }
}
