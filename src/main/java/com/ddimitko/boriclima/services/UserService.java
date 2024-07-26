package com.ddimitko.boriclima.services;

import com.ddimitko.boriclima.DTO.User.UserCreationDto;
import com.ddimitko.boriclima.DTO.User.UserDto;
import com.ddimitko.boriclima.entities.User;
import com.ddimitko.boriclima.mappers.UserMapper;
import com.ddimitko.boriclima.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> findAll(){
        List<User> userList = userRepository.findAll();
        return userMapper.usersToUserDtos(userList);
    }

    public void saveUser(@Valid UserCreationDto userCreationDto) {
        userRepository.save(userMapper.userCreationDtoToUser(userCreationDto));
    }

    public User findById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}
