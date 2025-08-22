package com.hackers.blogbackend.dto.postdto;

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
public class PostCreateDto {
    private String id;
    private String title;
    private String content;
    private boolean published;
    private String difficulty;
    private String media;
    private boolean view;
    private String userId;
    private String categoryId;
    private Set<String> tags;


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        PostCreateDto post = (PostCreateDto) o;
        return id != null && id.equals(post.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
