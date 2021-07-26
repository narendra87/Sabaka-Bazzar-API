package com.sap.spring.mongodb.config;

import com.sap.spring.mongodb.modal.User;
import com.sap.spring.mongodb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
  @Autowired UserRepository userRepository;

  @Bean
  CommandLineRunner commandLineRunner() {
    return String -> {
      userRepository.save(new User("test", "test", "test@testebiz.com", "test123", "test123"));
    };
  }
}
