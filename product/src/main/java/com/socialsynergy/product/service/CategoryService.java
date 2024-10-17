package com.socialsynergy.product.service;

import com.socialsynergy.product.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(Long categoryId);
    Category create(Category category);
}
