package it.apuliadigitalmaker.dev2022.filmmanager.serviceImpl;

import it.apuliadigitalmaker.dev2022.filmmanager.requestDto.CategoryRequestDto;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.CategoryResponseDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.apuliadigitalmaker.dev2022.filmmanager.model.Category;

@Component
//@Scope("prototype")
public class CategoryConverter {

	public Category convertToEntity(CategoryRequestDto categoryRequest) {
		
		return new Category(null, categoryRequest.getName());
	}
	
	public CategoryResponseDto convertToDto(Category category) {
		
		return new CategoryResponseDto(category.getName(), category.getCategoryId());
	}
	
	public List<CategoryResponseDto> convertToDtoList(List<Category> categoryList) {
		
		return categoryList.stream().map(c -> convertToDto(c)).collect(Collectors.toList());
		
	}
	
}
