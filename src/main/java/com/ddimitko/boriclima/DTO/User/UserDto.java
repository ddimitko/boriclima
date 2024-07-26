package com.ddimitko.boriclima.DTO.User;

import com.ddimitko.boriclima.DTO.Review.ReviewDto;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String email;
    private String firstName;
    private String lastName;
    private List<ReviewDto> reviews;

}
