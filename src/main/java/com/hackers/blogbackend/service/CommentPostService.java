package com.hackers.blogbackend.service;

import java.util.List;


import com.hackers.blogbackend.dto.CommentDto;
import com.hackers.blogbackend.entity.Comment;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.CommentRepository;
import com.hackers.blogbackend.service.interfaces.CommentServiceInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentPostService implements CommentServiceInterface{

    private CommentRepository commentRepository;
    private BlMapper mapper;

    @Override
    public List<CommentDto> getPostComments(String postId) {
        return commentRepository.findByPostId(postId).stream()
                                                .map(mapper::maps)
                                                .toList();
    }

    @Override
    public CommentDto getCommentById(String id) throws Exception {
            checkExist(id);
            return mapper.maps(commentRepository.findById(id).get());
        
    }

    @Override
    public CommentDto doPostComment(CommentDto commentDto) {
        return mapper.maps(this.commentRepository.save(mapper.maps(commentDto)));
    }

    @Override
    public CommentDto doUpdateComment(String id, CommentDto commentDto) {
        Comment comment = mapper.maps(commentDto);
        comment.setId(id);
        return mapper.maps(this.commentRepository.save(comment));
    }

    @Override
    public void deleteCommentById(String id) throws Exception {
        checkExist(id);
        commentRepository.deleteById(id);
    }


    private void checkExist(String id) throws Exception{
        if (!commentRepository.existsById(id)) {
            throw new Exception("aucun commentaire avec ce identifiant n'existe");
        }
    }

}
