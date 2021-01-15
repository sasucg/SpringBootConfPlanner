package com.project.demoproject.service;

import com.project.demoproject.entities.DictionaryConferenceCategory;
import com.project.demoproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<DictionaryConferenceCategory> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Transactional
    public void addCategory(DictionaryConferenceCategory category) {
        categoryRepository.addCategory(category);
    }

    public void updateCategory(DictionaryConferenceCategory category) {
        categoryRepository.updateCategory(category);
    }

    public void deleteCategoryy(DictionaryConferenceCategory category) {
        categoryRepository.deleteCategory(category);
    }

    public DictionaryConferenceCategory getCategoryById(int id) {
        return categoryRepository.getCategoryById(id);
    }
}
