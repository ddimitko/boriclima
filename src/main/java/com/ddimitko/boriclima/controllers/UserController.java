package com.ddimitko.boriclima.controllers;

import com.ddimitko.boriclima.DTO.User.UserCreationDto;
import com.ddimitko.boriclima.DTO.User.UserDto;
import com.ddimitko.boriclima.entities.User;
import com.ddimitko.boriclima.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserCreationDto userCreationDto){
        userService.saveUser(userCreationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
