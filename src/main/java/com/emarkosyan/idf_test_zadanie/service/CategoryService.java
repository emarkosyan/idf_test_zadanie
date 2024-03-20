package com.emarkosyan.idf_test_zadanie.service;

import com.emarkosyan.idf_test_zadanie.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
