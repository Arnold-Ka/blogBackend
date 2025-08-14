package com.hackers.blogbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackers.blogbackend.dto.PostDto;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    PostRepository postRepository;
    BlMapper mapper = Mappers.getMapper(BlMapper.class);
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    /**
     * Recuperation de touts les posts.
     * @return la liste de tout les posts
     */
    @Transactional
    public List<PostDto> getPost(){
        return postRepository.findAll().stream()
                            .map(mapper::maps)
                    
                            .collect(Collectors.toList());
    }

    /**
     * Recuperation d'un post.
     * @id l'identifiant du post
     * @return un Optional contenant le PostDto si trouvé, ou vide si non trouvé
     */
    @Transactional
    public Optional<PostDto> getPostById(final String id){
        return postRepository.findById(id)
                             .map(mapper::maps);
    }
}
