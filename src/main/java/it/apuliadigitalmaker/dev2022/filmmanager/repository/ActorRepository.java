package it.apuliadigitalmaker.dev2022.filmmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.apuliadigitalmaker.dev2022.filmmanager.model.Actor;

public interface ActorRepository extends MongoRepository<Actor, String>{

}
