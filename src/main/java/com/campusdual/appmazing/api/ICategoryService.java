package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    public CategoryDTO queryCategory (CategoryDTO CategoryDTO);
    List<CategoryDTO> queryAllCategories();
    int insertCategory (CategoryDTO categoryDTO);
    int updateCategory (CategoryDTO categoryDTO);
    int deleteCategory (CategoryDTO categoryDTO);
}
