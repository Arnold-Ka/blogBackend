package com.hackers.blogbackend.service;

import java.util.List;

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

    /**
     * Recuperation d'une categorie par son identifiant.
     * @param id l'identifiant de la categorie
     * @return la categorie si trouvée, sinon null
     */
    public CategoryDto getCategory(String id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Catégorie non trouvée");
        }
        return repository.findById(id).map(mapper::maps).orElse(null);
    }
    /**
     * Recuperation de toutes les categories.
     * @return la liste des categories
     */
    public List<CategoryDto> getCategories(){
        return repository.findAllActive()
                        .stream()
                        .map(mapper::maps)
                        .toList();
    }

    /**
     * Creation d'une categorie.
     * @param categoryDto la categorie a creer
     * @return la categorie creee
     */
    public CategoryDto postCategory(CategoryDto categoryDto) {
        if (categoryDto == null || repository.existsByName(categoryDto.getName())) {
            throw new IllegalArgumentException("Catégorie invalide");
        }
        return mapper.maps(repository.save(mapper.maps(categoryDto)));
    }
    /**
     * Mise a jour d'une categorie.
     * @param id l'identifiant de la categorie a mettre a jour
     * @param categoryDto la categorie mise a jour
     * @return la categorie mise a jour
     */

    public CategoryDto putCategory(String id, CategoryDto categoryDto) {
        if (categoryDto == null || !repository.existsById(id)) {
            throw new IllegalArgumentException("Catégorie invalide");
        }
        return repository.findByIdAndActive(id, EStatut.ACTIVE)
                         .map(existingCategory -> {
                             existingCategory.setName(categoryDto.getName());
                             existingCategory.setDescription(categoryDto.getDescription());
                             return mapper.maps(repository.save(existingCategory));
                         })
                         .orElse(null);
    }


}
