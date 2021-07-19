package com.sap.spring.mongodb.repository.sabakabazzar;

import com.sap.spring.mongodb.modal.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDetails,Long> {
}
