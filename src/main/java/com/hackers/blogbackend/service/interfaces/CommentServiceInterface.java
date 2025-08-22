package com.hackers.blogbackend.service.interfaces;

import com.hackers.blogbackend.dto.CommentDto;

import java.util.List;
import java.util.Optional;

public interface CommentServiceInterface {

    /**
     * Récupère la liste de tous les commentaire d'un post
     * @return la liste de commentaire d'un post
     */
    public List<CommentDto> getPostComments(final String postId);
    public Optional<CommentDto> getCommentById(final String id);
    public CommentDto doPostComment(final CommentDto commentDto, final String postId);
    public CommentDto doUpdateComment(final String id, final CommentDto commentDto);
    public void  deleteCommentById(final String id);
}
