package com.ddimitko.boriclima.mappers;

import com.ddimitko.boriclima.DTO.Review.ReviewCreationDto;
import com.ddimitko.boriclima.DTO.Review.ReviewDto;
import com.ddimitko.boriclima.entities.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review reviewCreationDtoToReview(ReviewCreationDto reviewCreationDto);
    ReviewDto reviewToReviewDto(Review review);
    List<ReviewDto> reviewsToReviewDtos(List<Review> reviews);


}
