package com.sap.spring.mongodb.controller.user;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.LoginResponse;
import com.sap.spring.mongodb.modal.User;
import com.sap.spring.mongodb.repository.sabakabazzar.CartRepository;
import com.sap.spring.mongodb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserController {
  @Autowired UserRepository userRepository;
  @Autowired
  CartRepository cartRepository;
  @GetMapping("/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/user")
  public User getUser(@RequestParam(value = "email") String email) {
    Iterator iterator = userRepository.findAll().iterator();
    while (iterator.hasNext()) {
      User user = (User) iterator.next();
      if (user.getEmail().equals(email)) {
        return user;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }

  @PostMapping("/users/login")
  public ResponseEntity loginUser(@RequestBody User userLogin) {

    Iterator iterator = userRepository.findAll().iterator();
    while (iterator.hasNext()) {
      User user = (User) iterator.next();
      if (user.getEmail().equals(userLogin.getEmail()) && user.getPassword().equals(userLogin.getPassword())) {
        return new ResponseEntity(new LoginResponse(cartRepository.findAll().size(),"success","user login successfully"),HttpStatus.OK);
      }
    }
    throw new RecordNotFoundException("Invalid userid or password");
  }

  @PostMapping("/users/register")
  public ResponseEntity<Object> registerUser(@RequestBody @Validated User user) {
    userRepository.save(user);
    return new ResponseEntity(new LoginResponse(0,"success","user registered successfully"),HttpStatus.OK);
//    URI location =
//        ServletUriComponentsBuilder.fromCurrentRequest()
//            .path("/{id}")
//            .buildAndExpand(user.getEmail())
//            .toUri();
//    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users")
  public void deleteUser(@RequestParam(value = "email") String email) {
    Iterator iterator = userRepository.findAll().iterator();
    while (iterator.hasNext()) {
      User user = (User) iterator.next();
      if (user.getEmail().equals(email)) {
        userRepository.delete(user);
        return;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }
}
