package com.ddimitko.boriclima.controllers;

import com.ddimitko.boriclima.DTO.Product.ProductCreationDto;
import com.ddimitko.boriclima.DTO.Product.ProductDto;
import com.ddimitko.boriclima.DTO.Review.ReviewCreationDto;
import com.ddimitko.boriclima.DTO.Review.ReviewDto;
import com.ddimitko.boriclima.entities.Product;
import com.ddimitko.boriclima.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductCreationDto productCreationDto) {
        productService.saveProduct(productCreationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*@PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        try {
            Product product = productService.updateProduct(id, productRequest.getProductName(),
                    productRequest.getProductDescription(),
                    productRequest.getProductPrice(),
                    productRequest.getProductImage());
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/reviews")
    public List<ReviewDto> getReviews() {
        return productService.getAllReviews();
    }

    @PostMapping("/addReview")
    public ResponseEntity<Void> createReview(@Valid @RequestBody ReviewCreationDto reviewCreationDto) {
        productService.createReview(reviewCreationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
