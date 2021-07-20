package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.CartItems;
import com.sap.spring.mongodb.repository.sabakabazzar.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class CartController {
  @Autowired CartRepository cartRepository;

  @GetMapping("/sabakabazzar/cart/items")
  public List<CartItems> getCartItems() {
    return cartRepository.findAll();
  }
  @GetMapping("/sabakabazzar/cart/item")
  public CartItems getCartItem(@RequestParam(value = "id") String id) {
    Iterator iterator = cartRepository.findAll().iterator();
    while (iterator.hasNext()) {
      CartItems product = (CartItems) iterator.next();
      if (product.getId().equals(id) ){
        return product;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }

  @PostMapping("/sabakabazzar/cart/addToCart")
  public ResponseEntity<Object> addToCart(@RequestBody CartItems cartItems) {
    cartRepository.save(cartItems);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cartItems.getId()).toUri();
    return  ResponseEntity.created(location).build();
  }

  @DeleteMapping("/sabakabazzar/cart/item")
  public void deleteProduct(@RequestParam(value = "id") String id) {
    Iterator iterator = cartRepository.findAll().iterator();
    while (iterator.hasNext()) {
      CartItems product = (CartItems) iterator.next();
      if (product.getId().equals(id) ){
        cartRepository.delete(product);
        return;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }
}
