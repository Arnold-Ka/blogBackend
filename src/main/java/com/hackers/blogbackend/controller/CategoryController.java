package com.hackers.blogbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.hackers.blogbackend.dto.CategoryDto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;



import com.hackers.blogbackend.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * Get all categories.
     * @return list of CategoryDto
     */
    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getCategories();
    }


    /**
     * Get category by id.
     * @param id the category id
     * @return  the CategoryDto
     */
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable String id) {
        return categoryService.getCategory(id);
    }

    /**
     * Create a new category.
     * @param categoryDto the CategoryDto to create
     * @return the created CategoryDto
     */
    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.postCategory(categoryDto);
    }

    /**
     * Update an existing category.
     * @param id the category id
     * @param categoryDto the CategoryDto to update
     * @return the updated CategoryDto
     */
    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable String id, @RequestBody CategoryDto categoryDto) {
        return categoryService.putCategory(id, categoryDto);
    }

    /**
     * Delete a category by id.
     * @param id the category id
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }

}
