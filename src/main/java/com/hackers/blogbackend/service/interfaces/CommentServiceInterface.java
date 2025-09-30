package com.hackers.blogbackend.service.interfaces;

import com.hackers.blogbackend.dto.CommentDto;

import java.util.List;

public interface CommentServiceInterface {

    /**
     * Récupère la liste de tous les commentaire d'un post
     * @return la liste de commentaire d'un post
     */
    public List<CommentDto> getPostComments(final String postId);
    public CommentDto getCommentById(final String id) throws Exception;
    public CommentDto doPostComment(final CommentDto commentDto);
    public CommentDto doUpdateComment(final String id, final CommentDto commentDto) throws Exception;
    public void  deleteCommentById(final String id) throws Exception;
}
