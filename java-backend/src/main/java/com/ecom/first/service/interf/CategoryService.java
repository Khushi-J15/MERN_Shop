package com.ecom.first.service.interf;

import com.ecom.first.dto.Response;
import com.ecom.first.dto.CategoryDto;

public interface CategoryService {

    Response createCategory(CategoryDto categoryRequest);
    Response updateCategory(Long categoryId, CategoryDto categoryRequest);
    Response getAllCategories();
    Response getCategoryById(Long categoryId);
    Response deleteCategory(Long categoryId);
}
