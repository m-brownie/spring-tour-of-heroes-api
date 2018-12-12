package com.boot.hero.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.boot.hero.model.Hero;

@RepositoryRestResource(path="heroes")
public interface HeroRepository extends CrudRepository<Hero, Integer> {
	
	Optional<Hero[]> findByNameContaining(@Param("name") String name);

}
