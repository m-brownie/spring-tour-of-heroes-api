package com.boot.hero.service;

import com.boot.hero.model.Hero;
import com.boot.hero.model.HeroDto;

public interface HeroService {
	
	Iterable<Hero> findAll();
	
	Hero findById(int id);
	
	HeroDto update(HeroDto heroDto);
}
