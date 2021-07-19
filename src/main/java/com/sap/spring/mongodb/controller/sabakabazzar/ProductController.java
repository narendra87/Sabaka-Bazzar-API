package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.ProductDetails;
import com.sap.spring.mongodb.repository.sabakabazzar.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
  @Autowired
  ProductRepository productRepository;

  @GetMapping("/sabakabazzar/products")
  public List<ProductDetails> getProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/sabakabazzar/products/{id}")
  public Optional<ProductDetails> getProduct(@PathVariable Long id) {
    Optional<ProductDetails> product = productRepository.findById(id);
    if (!product.isEmpty()) {
      return product;
    } else {
      throw new RecordNotFoundException("No data found for given ID");
    }
  }

  @PostMapping("/sabakabazzar/products")
  public void addProduct(@RequestBody ProductDetails productDetails) {
    productRepository.save(productDetails);
  }

  @DeleteMapping("/sabakabazzar/products/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productRepository.deleteById(id);
  }
}
