package it.apuliadigitalmaker.dev2022.filmmanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.dev2022.filmmanager.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	public List<Category> findByName(String name);
	
	public List<Category> findByNameLikeIgnoreCase(String name);

}
