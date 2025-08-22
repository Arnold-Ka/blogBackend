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
public class CategoryDto {
    private String id;
    private String name;
    private String slug;
    private String description;
    private String icon;

    @SuppressWarnings("null")
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null | getClass() != o.getClass()){
            return false;
        }
        CategoryDto category = (CategoryDto) o;
        return id.equals(category.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
