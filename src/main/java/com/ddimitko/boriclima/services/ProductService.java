package com.ddimitko.boriclima.services;

import com.ddimitko.boriclima.DTO.Product.ProductCreationDto;
import com.ddimitko.boriclima.DTO.Product.ProductDto;
import com.ddimitko.boriclima.DTO.Review.ReviewCreationDto;
import com.ddimitko.boriclima.DTO.Review.ReviewDto;
import com.ddimitko.boriclima.entities.Product;
import com.ddimitko.boriclima.entities.Review;
import com.ddimitko.boriclima.mappers.ProductMapper;
import com.ddimitko.boriclima.mappers.ReviewMapper;
import com.ddimitko.boriclima.repositories.ProductRepository;
import com.ddimitko.boriclima.repositories.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.productsToProductDtos(products);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long prodId, String prodBrand,
                                 String prodModel,
                                 String prodDescription, BigDecimal prodPrice, String prodImage){
        Product product = productRepository.findById(prodId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductBrand(prodBrand);
        product.setProductModel(prodModel);
        product.setProductDescription(prodDescription);
        product.setProductPrice(prodPrice);
        product.setProductImage(prodImage);

        return productRepository.save(product);
    }

    public void saveProduct(@Valid ProductCreationDto productCreationDto) {
        productRepository.save(productMapper.productCreationDtoToProduct(productCreationDto));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //Reviews
    public void createReview(@Valid ReviewCreationDto reviewCreationDto) {
        reviewRepository.save(reviewMapper.reviewCreationDtoToReview(reviewCreationDto));
    }

    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.reviewsToReviewDtos(reviews);
    }

}
