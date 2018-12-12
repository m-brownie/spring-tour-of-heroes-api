package com.boot.hero.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.hero.model.Hero;
import com.boot.hero.model.HeroDto;
import com.boot.hero.model.UserDto;
import com.boot.hero.repository.HeroRepository;
import com.boot.hero.service.HeroService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HeroController {
	
	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping(path="/heroes")
	public @ResponseBody Iterable<Hero> getAllHeroes() {
		return heroService.findAll();
	}
	
	@GetMapping(path="/heroes/{id}")
	public @ResponseBody Optional<Hero> getHero(@PathVariable final Integer id) {
		return heroRepository.findById(id);
	}
	
	@GetMapping(path="/heroes", params="name")
	public @ResponseBody Optional<Hero[]> getByName(@RequestParam("name") String name) {
		Optional<Hero[]> heroes = heroRepository.findByNameContaining(name);
		return heroes;
	}
	
	@PutMapping
	public HeroDto update(@RequestBody HeroDto heroDto) {
		return heroService.update(heroDto);
	}
}
