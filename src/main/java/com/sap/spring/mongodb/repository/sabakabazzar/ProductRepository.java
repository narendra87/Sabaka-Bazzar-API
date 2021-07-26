package com.sap.spring.mongodb.repository.sabakabazzar;

import com.sap.spring.mongodb.modal.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductDetails,String> {
    List<ProductDetails> findByCategory(String categoryId);
}
