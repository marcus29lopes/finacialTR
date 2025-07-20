package com.app.financialTR.controller;

import com.app.financialTR.model.Category;
import com.app.financialTR.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/FTR")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/category/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
