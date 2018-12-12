package com.boot.hero.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.hero.model.Hero;
import com.boot.hero.model.HeroDto;
import com.boot.hero.repository.HeroRepository;

@Service(value = "heroService")
public class HeroServiceImpl implements HeroService {
	
	@Autowired
	private HeroRepository heroRepository;
	
	@Override
	public Iterable<Hero> findAll() {
		return heroRepository.findAll();
	}
	
	@Override
	public Hero findById(int id) {
		Optional<Hero> optionalHero = heroRepository.findById(id);
		return optionalHero.isPresent() ? optionalHero.get() : null;
	}

	@Override
	public HeroDto update(HeroDto heroDto) {
		Hero hero = findById(heroDto.getId());
		
        if(hero != null) {
            BeanUtils.copyProperties(heroDto, hero);
            heroRepository.save(hero);
        }
        
        return heroDto;
	}
}
