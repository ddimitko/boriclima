package com.ddimitko.boriclima.mappers;

import com.ddimitko.boriclima.DTO.User.UserCreationDto;
import com.ddimitko.boriclima.DTO.User.UserDto;
import com.ddimitko.boriclima.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);
    List<UserDto> usersToUserDtos(List<User> users);
    User userCreationDtoToUser(UserCreationDto userCreationDto);

    @Mapping(target = "userId", ignore = true)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);

}
