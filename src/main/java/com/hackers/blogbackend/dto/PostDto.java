package com.hackers.blogbackend.dto;

import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String aiSummary;
    private boolean view;
    private boolean published;
    private String estimateTimeToRead;
    private String difficulty;
    private Long userId;
    private Long categoryId;
    private Set<String> tags;

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        PostDto post = (PostDto) o;
        return id != null && id.equals(post.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
