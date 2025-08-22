package com.hackers.blogbackend.service.interfaces;

import com.hackers.blogbackend.dto.PostDto;
import com.hackers.blogbackend.dto.postdto.PostCreateDto;

import java.util.List;
import java.util.Optional;

public interface PostServiceInterface {

    /**
     * La defini de la methode sencé implementé la recupération de données.
     * @return la liste des poste actives
     */
    public List<PostDto> getPost();

    /**
     * Recupere un post a travers son identifiant.
     * @param id l'identifiant du post
     * @return le post
     */
    public Optional<PostDto> getPostById(final String id);

    /**
     * Ajoute un nouveau post.
     * @param postDto le contenu du futur  post
     * @return le post nouveau post
     */
    public PostDto doPostPost(final PostCreateDto postCreateDto);

    /**
     * Met a jour un post a travers son identifiant.
     * @param postDto la modofication
     * @return le post mis a jour
     */
    public PostDto doUpdatePost(final String id,final PostCreateDto postCrateDto);

    /**
     * Supprime un post a travers son identifiant.
     * @param id l'indentifiant du post a supprimer
     */
    public void doDeletePost(final String id);
}
