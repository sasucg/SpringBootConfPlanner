package com.project.demoproject.controller;

import com.project.demoproject.entities.DictionaryConferenceCategory;
import com.project.demoproject.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DictionaryConferenceCategory>> getAllCategories() {

        List<DictionaryConferenceCategory> cities = categoryService.getAllCategories();

        if (cities.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of());
        else return ResponseEntity
                .ok()
                .body(cities);
    }

    @GetMapping("/{id}")
    public DictionaryConferenceCategory getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/save")
    public void addCategory(@RequestBody DictionaryConferenceCategory category)    { categoryService.addCategory(category); }

    @PutMapping("/save")
    public void updateCategory(@RequestBody DictionaryConferenceCategory category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete")
    public void deleteCategoryy(@RequestBody DictionaryConferenceCategory category) {
        categoryService.deleteCategoryy(category);
    }
}
