package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.CartItems;
import com.sap.spring.mongodb.repository.sabakabazzar.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
  @Autowired CartRepository cartRepository;

  @GetMapping("/sabakabazzar/cart/items")
  public List<CartItems> getCartItems() {
    return cartRepository.findAll();
  }

  @GetMapping("/sabakabazzar/cart/items/{id}")
  public Optional<CartItems> getCartItem(@PathVariable Long id) {
    Optional<CartItems> product = cartRepository.findById(id);
    if (!product.isEmpty()) {
      return product;
    } else {
      throw new RecordNotFoundException("No data found for given ID");
    }
  }

  @PostMapping("/sabakabazzar/cart/addToCart")
  public void addToCart(@RequestBody CartItems cartItems) {
    cartRepository.save(cartItems);
  }

  @DeleteMapping("/sabakabazzar/cart/items/{id}")
  public void deleteProduct(@PathVariable Long id) {
    cartRepository.deleteById(id);
  }
}
