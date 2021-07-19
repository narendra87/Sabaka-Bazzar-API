package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.modal.Category;
import com.sap.spring.mongodb.repository.sabakabazzar.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class CategoryController {
        @Autowired
        CategoryRepository categoryRepository;

        @GetMapping("/sabakabazzar/categories")
        public List<Category> getCategories() {
            return categoryRepository.findAll();
        }
}
