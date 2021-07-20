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

@RestController
public class UserController {
  @Autowired UserRepository userRepository;

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
  public User loginUser(
      @RequestParam(value = "email") String email,
      @RequestParam(value = "password") String password) {

    Iterator iterator = userRepository.findAll().iterator();
    while (iterator.hasNext()) {
      User user = (User) iterator.next();
      if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
       User temp = new User();
        temp.setFirstname(user.getFirstname());
        temp.setLastname(user.getLastname());
        temp.setEmail(user.getEmail());
        return temp;
      }
    }
    throw new RecordNotFoundException("Invalid userid or password");
  }

  @PostMapping("/users/register")
  public ResponseEntity<Object> registerUser(@RequestBody @Validated User user) {
    userRepository.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getEmail())
            .toUri();
    return ResponseEntity.created(location).build();
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
