package com.sap.spring.mongodb.repository.sabakabazzar;

import com.sap.spring.mongodb.modal.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Long> {
}
