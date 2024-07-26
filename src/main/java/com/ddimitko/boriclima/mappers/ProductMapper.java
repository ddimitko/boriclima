package com.ddimitko.boriclima.mappers;

import com.ddimitko.boriclima.DTO.Product.ProductCreationDto;
import com.ddimitko.boriclima.DTO.Product.ProductDto;
import com.ddimitko.boriclima.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productCreationDtoToProduct(ProductCreationDto productCreationDto);
    ProductDto productToProductDto(Product product);
    List<ProductDto> productsToProductDtos(List<Product> products);

}
