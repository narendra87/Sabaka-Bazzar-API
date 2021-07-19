package com.sap.spring.mongodb.repository.sabakabazzar;

import com.sap.spring.mongodb.modal.CartItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<CartItems,Long> {
}
