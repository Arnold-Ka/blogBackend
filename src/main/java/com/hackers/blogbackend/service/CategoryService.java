package com.hackers.blogbackend.service;

import org.springframework.stereotype.Service;

import com.hackers.blogbackend.dto.CategoryDto;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.CategoryRepository;


@Service
public class CategoryService {
    CategoryRepository repository;
    BlMapper mapper;

    /**
     * Constructor for CategoryService and dependency injection.
     * @param repository the category repository
     * @param mapper the Blob mapper
     */
    public CategoryService(CategoryRepository repository, BlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CategoryDto getCategoryIdById(String id) {
        return repository.findById(id).map(mapper::maps).orElse(null);
    }


}
