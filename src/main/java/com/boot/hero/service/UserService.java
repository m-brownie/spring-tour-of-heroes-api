package com.boot.hero.service;

import com.boot.hero.model.User;
import com.boot.hero.model.UserDto;

public interface UserService {
	
	User save(UserDto user);
	
    Iterable<User> findAll();
    
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);

}
