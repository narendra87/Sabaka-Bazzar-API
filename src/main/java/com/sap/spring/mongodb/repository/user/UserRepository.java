package com.sap.spring.mongodb.repository.user;

import com.sap.spring.mongodb.modal.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
}
