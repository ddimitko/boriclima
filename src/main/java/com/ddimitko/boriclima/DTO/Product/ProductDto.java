package com.ddimitko.boriclima.DTO.Product;

import com.ddimitko.boriclima.DTO.Review.ReviewDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {

    private String productBrand;
    private String productModel;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productDescription;
    private List<ReviewDto> reviews;

}
