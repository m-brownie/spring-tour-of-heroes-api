package com.boot.hero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.hero.model.ApiResponse;
import com.boot.hero.model.User;
import com.boot.hero.model.UserDto;
import com.boot.hero.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/users")
    public ApiResponse<User> saveUser(@RequestBody UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.save(user));
    }

    @GetMapping(path="/users")
    public Iterable<User> listUser(){
        return userService.findAll();
    }

    @GetMapping(path="/users/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", userService.findById(id));
    }

    @PutMapping(path="/users/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", userService.update(userDto));
    }

    @DeleteMapping(path="/users/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }
}
