package it.apuliadigitalmaker.dev2022.filmmanager.service;


import java.util.List;

import it.apuliadigitalmaker.dev2022.filmmanager.requestDto.CategoryRequestDto;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.CategoryResponseDto;

public interface CategoryService {
	
	public List<CategoryResponseDto> findCategories(String name) ;
	
	public CategoryResponseDto findCategoryById(String id);
	
	public CategoryResponseDto createCategory(CategoryRequestDto categoryRequest);
	
	public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequest, String categoryId);
	
	public boolean deleteCategory(String id);

}
