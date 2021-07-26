package com.sap.spring.mongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Document
public class User {
  @Size(min = 2, max = 20)
  @NotEmpty
  private String firstname;

  @Size(min = 2, max = 20)
  private String lastname;

  @Email @Id @NotEmpty private String email;

  @Size(min = 6, max = 20)
  @NotEmpty
  private String password;

  public User() {}

  public User(
      String firstname, String lastname, String email, String password, String confirmPassword) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public User setFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public String getLastname() {
    return lastname;
  }

  public User setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public String toString() {
    return "User{"
        + "firstname='"
        + firstname
        + '\''
        + ", lastname='"
        + lastname
        + '\''
        + ", email='"
        + email
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
