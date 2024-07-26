package com.ddimitko.boriclima.DTO.Product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreationDto {

    @NotNull
    private String productBrand;

    @NotNull
    private String productModel;
    private BigDecimal productPrice;
    private Integer productQuantity;

    @NotNull
    private String productDescription;

}
