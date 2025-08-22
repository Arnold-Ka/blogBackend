package com.hackers.blogbackend.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String id;
    private String content;
    private Long postId;
    private Long userId;
    private Long parentId;

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        CommentDto comment = (CommentDto) o;
        return id.equals(comment.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
