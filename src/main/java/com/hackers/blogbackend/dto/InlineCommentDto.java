package com.hackers.blogbackend.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InlineCommentDto {
    private String id;
    private String content;
    private String target;
    private Long postId;
    private Long userId;

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        InlineCommentDto inlineComment = (InlineCommentDto) o;
        return id.equals(inlineComment.id);
    }

    
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}