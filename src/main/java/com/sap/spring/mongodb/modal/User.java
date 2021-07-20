package com.sap.spring.mongodb.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Component
public class User {

  @Size(min = 2)
  private String firstname;

  @Size(min = 2)
  private String lastname;

  @Email @Id private String email;

  @Size(min = 6)
  private String password;
  @Size(min = 6)
  private String confirmPassword;

  public User() {}

  public User(
      String firstname, String lastname, String email, String password, String confirmPassword) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
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

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public User setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
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
        + ", confirmPassword='"
        + confirmPassword
        + '\''
        + '}';
  }
}
