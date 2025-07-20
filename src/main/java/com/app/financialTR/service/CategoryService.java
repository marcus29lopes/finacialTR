package com.app.financialTR.service;

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

    public void addCategory(Category category) {

        Boolean isCategoryFound = categoryRepository.existsByNmCategory(category.getNmCategory());

        if (isCategoryFound) throw new DuplicateNameException("Category named " + category.getNmCategory());

        categoryRepository.save(category);
    }
}
