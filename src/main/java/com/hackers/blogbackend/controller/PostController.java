package com.hackers.blogbackend.controller;

import com.hackers.blogbackend.dto.PostDto;
import com.hackers.blogbackend.dto.postdto.PostCreateDto;
import com.hackers.blogbackend.service.interfaces.PostServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {
    PostServiceInterface postService;

    /**
     * L'api de la liste des post.
     * @return la liste des post sous format json
     */
    @GetMapping(value = "/posts")
    public List<PostDto> getPosts(){
        return postService.getPost();
    }

    /**
     * Recuperation d'un post via son identfiant passer en url.
     * @param id l'identifiant du post
     * @return le post
     */
    @GetMapping(value = "/posts/{id}")
    public Optional<PostDto> getPost(@PathVariable final String id){
        return postService.getPostById(id);
    }

    /**
     * Ajout d'un nouveau post.
     * @param postDto le contenu du post
     * @return le post
     */
    @PostMapping(value = "/posts")
    public PostDto createPost(@RequestBody final PostCreateDto postCreateDto){
        return postService.doPostPost(postCreateDto);
    }

    /**
     * Mise a jour d'un post.
     * @param id l'identifiant d'un post
     * @param postDto le nouveau contenu du post
     * @return le nouveau post
     */
    @PutMapping(value = "/post/{id}")
    public PostDto updatePost(@PathVariable final String id, @RequestBody final PostCreateDto postCreateDto){
        return postService.doUpdatePost(id, postCreateDto);
    }

    /**
     * Suppression d'un post a partir de son identifiant.
     * @param id
     */
    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable final String id){
        postService.doDeletePost(id);
    }

}
