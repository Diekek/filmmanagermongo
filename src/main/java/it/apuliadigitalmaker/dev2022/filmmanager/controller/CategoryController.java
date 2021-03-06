package it.apuliadigitalmaker.dev2022.filmmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigitalmaker.dev2022.filmmanager.common.CommonResponseCode;
import it.apuliadigitalmaker.dev2022.filmmanager.requestDto.CategoryRequestDto;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.BaseResponseBody;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.CategoryResponseDto;
import it.apuliadigitalmaker.dev2022.filmmanager.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getCategories(@RequestParam(required = false) String name) {
	
		List<CategoryResponseDto> result = categoryService.findCategories(name);
		if (result.isEmpty()) {
			return createNotFoundResponse();
		} else {
			return createSuccessResponse(result);
		}
		
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategoryById(@PathVariable(name="categoryId", required=true) String categoryId) {

		CategoryResponseDto result = categoryService.findCategoryById(categoryId);
		if (result == null) {
			return createNotFoundResponse();
		} else {
			return createSuccessResponse(result);
		}

	}
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody(required = true) CategoryRequestDto categoryDto) {
		return createSuccessResponse(categoryService.createCategory(categoryDto));
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryRequestDto categoryDto, 
			@PathVariable("categoryId") String categoryId) {
		CategoryResponseDto categoryResponse;
		try {
			categoryResponse = categoryService.updateCategory(categoryDto, categoryId);
		} catch (IllegalArgumentException e) {
			return createNotFoundResponse();
		}
		return createSuccessResponse(categoryResponse);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId) {
		try {
			categoryService.deleteCategory(categoryId);
		} catch(EmptyResultDataAccessException e) {
			return createNotFoundResponse();
		}
			return createSuccessResponse(null);
	}
	
	private BaseResponseBody<Object> getEmptyResponse() {
		return new BaseResponseBody<>(false, CommonResponseCode.NOT_FOUND.getMessage(), CommonResponseCode.NOT_FOUND.getResponseCode(), null);
	}
	
	private <T> BaseResponseBody<T> getDataResponse(T data) {
		return new BaseResponseBody<>(true, CommonResponseCode.OK.getMessage(), CommonResponseCode.OK.getResponseCode(), data);
	}
	
	private ResponseEntity<?> createNotFoundResponse() {
		return new ResponseEntity<>(
				BaseResponseBody.builder().message(CommonResponseCode.NOT_FOUND.getMessage())
				.responseCode(CommonResponseCode.NOT_FOUND.getResponseCode())
				.success(false).build(), HttpStatus.NOT_FOUND);
	}

	private <T> ResponseEntity<?> createSuccessResponse(T payload) {
		return new ResponseEntity<>(
				BaseResponseBody.builder()
				.message(CommonResponseCode.OK.getMessage())
				.responseCode(CommonResponseCode.OK.getResponseCode())
				.success(true)
				.data(payload)
				.build(), HttpStatus.OK);
	}

}
