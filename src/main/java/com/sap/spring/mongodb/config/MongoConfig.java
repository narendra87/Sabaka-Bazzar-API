package com.sap.spring.mongodb.config;

import com.sap.spring.mongodb.modal.ProductDetails;
import com.sap.spring.mongodb.modal.User;
import com.sap.spring.mongodb.repository.sabakabazzar.ProductRepository;
import com.sap.spring.mongodb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
  @Autowired UserRepository userRepository;
  @Autowired
  ProductRepository productRepository;

  @Bean
  CommandLineRunner commandLineRunner() {
    return String -> {
      userRepository.save(new User("test", "test", "test@testebiz.com", "test123", "test123"));

      productRepository.save(
          new ProductDetails(
              "5b6c6a7f01a7c38429530883",
              "Fresho Kiwi - Green, 3 pcs",
              "Kiwis are oval shaped with a brownish outer skin. The flesh is bright green and juicy with tiny, edible black seeds.",
              "/static/images/products/fruit-n-veg/kiwi-green.jpg",
              87,
              50,
              "5b6899953d1a866534f516e2",
              "fnw-kiwi-3"));
    };
  }
}
