package com.ddimitko.boriclima.DTO.Review;

import com.ddimitko.boriclima.DTO.Product.ProductDto;
import com.ddimitko.boriclima.DTO.User.UserDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewCreationDto {

    @NotNull
    private UserDto user;

    @NotNull
    private ProductDto product;

    @NotNull
    private String reviewText;

    @NotNull
    private Integer rating;

}
