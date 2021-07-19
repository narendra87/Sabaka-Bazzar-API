package com.sap.spring.mongodb.controller.user;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.User;
import com.sap.spring.mongodb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
  @Autowired UserRepository userRepository;

  @GetMapping("/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public Optional<User> getUser(@PathVariable Long id) {
    Optional<User> user = userRepository.findById(id);
    if (!user.isEmpty()) {
      return user;
    } else {
      throw new RecordNotFoundException("No data found for given ID");
    }
  }

  @PostMapping("/users/login")
  public User loginUser(@RequestBody User user) {
    if (user != null) {
      Iterator iterator = userRepository.findAll().iterator();
      while (iterator.hasNext()) {
        User storedUser = (User) iterator.next();
        if (user.getEmail().equals(user.getEmail())) {
          return storedUser;
        }
      }
      return user;
    } else {
      throw new RecordNotFoundException("Please provide user details");
    }
  }

  @PostMapping("/users/register")
  public ResponseEntity<Object> registerUser(@RequestBody @Validated User user) {
    userRepository.save(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getEmail()).toUri();
    return  ResponseEntity.created(location).build();

  }

  @DeleteMapping("/users/{id}")
  public User deleteUser(@PathVariable String id) {
    Iterator iterator = userRepository.findAll().iterator();
    while (iterator.hasNext()) {
      User user = (User) iterator.next();
      if (user.getEmail().equals(id) ){
        userRepository.delete(user);
        return user;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }
}
