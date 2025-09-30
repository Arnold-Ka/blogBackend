package com.hackers.blogbackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackers.blogbackend.dto.CommentDto;
import com.hackers.blogbackend.service.CommentPostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post/{postId}/comments")
public class CommentController {
    CommentPostService commentPostService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComment(@RequestParam final String postId){
        List<CommentDto> data = commentPostService.getPostComments(postId);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/commentId")
    public ResponseEntity<CommentDto> getComment( @RequestParam final String commentId) throws Exception{
        CommentDto comment = commentPostService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

}
