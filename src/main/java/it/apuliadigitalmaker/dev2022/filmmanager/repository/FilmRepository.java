package it.apuliadigitalmaker.dev2022.filmmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.dev2022.filmmanager.model.Film;

public interface FilmRepository extends MongoRepository<Film, String>{

}
