package com.app.financialTR.service;

import com.app.financialTR.DTO.CategoryDTO;
import com.app.financialTR.exceptions.DuplicateNameException;
import com.app.financialTR.model.Category;
import com.app.financialTR.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(Long cdCategory) {

        return categoryRepository.findById(cdCategory);

    }

    public String addCategory(CategoryDTO categoryDTO) {

        if (categoryRepository.existsByNmCategory(categoryDTO.getNmCategory())) {
            throw new DuplicateNameException("Category named " + categoryDTO.getNmCategory());
        }

        Category category = new Category();
        category.setNmCategory(categoryDTO.getNmCategory());

        categoryRepository.save(category);

        return "Category named: " + categoryDTO.getNmCategory() + " added successfully";
    }
}
