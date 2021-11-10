package it.apuliadigitalmaker.dev2022.filmmanager.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigitalmaker.dev2022.filmmanager.model.Category;
import it.apuliadigitalmaker.dev2022.filmmanager.repository.CategoryRepository;
import it.apuliadigitalmaker.dev2022.filmmanager.requestDto.CategoryRequestDto;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.CategoryResponseDto;
import it.apuliadigitalmaker.dev2022.filmmanager.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	CategoryConverter categoryConverter;
	
	@Override
	public List<CategoryResponseDto> findCategories(String name) {
		
		if (name == null || name.isBlank()) {
			return categoryConverter.convertToDtoList(categoryRepo.findAll());
		} else {
			return categoryConverter.convertToDtoList(categoryRepo.findByNameLikeIgnoreCase(name));
		}
		
	}

	@Override
	public CategoryResponseDto findCategoryById(String id) {
		Optional<Category> categoryOpt = categoryRepo.findById(id);
		if (categoryOpt.isPresent()) {
			return categoryConverter.convertToDto(categoryOpt.get());
		} else {
			return null;
		}
	}

	@Override
	public CategoryResponseDto createCategory(CategoryRequestDto categoryRequest) {
		Category category = categoryConverter.convertToEntity(categoryRequest);
		category = categoryRepo.save(category);
		return categoryConverter.convertToDto(category);
	}

	@Override
	public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequest, String categoryId) {
		Optional<Category> categoryOpt = categoryRepo.findById(categoryId);
		Category category;
		if (categoryOpt.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			category = categoryOpt.get();
		}
		category = categoryConverter.convertToEntity(categoryRequest);
		category.setCategoryId(categoryId);
		category = categoryRepo.save(category);
		return categoryConverter.convertToDto(category);
	}

	@Override
	public boolean deleteCategory(String id) {
		categoryRepo.deleteById(id);
		return categoryRepo.findById(id).isEmpty();
	}
	
	

}
