package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.ProductDetails;
import com.sap.spring.mongodb.repository.sabakabazzar.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class ProductController {
  @Autowired ProductRepository productRepository;

  @GetMapping("/sabakabazzar/products")
  public List<ProductDetails> getProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/sabakabazzar/product")
  public ProductDetails getProduct(@RequestParam(value = "id") String id) {
    Iterator iterator = productRepository.findAll().iterator();
    while (iterator.hasNext()) {
      ProductDetails product = (ProductDetails) iterator.next();
      if (product.getId().equals(id)) {
        return product;
      }
    }
    throw new RecordNotFoundException("There is not product for given Id");
  }

  @PostMapping("/sabakabazzar/products")
  public ResponseEntity<Object> addProduct(@RequestBody ProductDetails productDetails) {
    productRepository.save(productDetails);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productDetails.getId()).toUri();
    return  ResponseEntity.created(location).build();
  }

  @DeleteMapping("/sabakabazzar/product")
  public void deleteProduct(@RequestParam(value = "id") String id) {
    Iterator iterator = productRepository.findAll().iterator();
    while (iterator.hasNext()) {
      ProductDetails product = (ProductDetails) iterator.next();
      if (product.getId().equals(id)) {
        productRepository.delete(product);
        return;
      }
    }
    throw new RecordNotFoundException("There is no product for given id");
    }
}
