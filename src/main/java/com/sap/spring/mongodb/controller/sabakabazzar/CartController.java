package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.CartItems;
import com.sap.spring.mongodb.modal.Response;
import com.sap.spring.mongodb.repository.sabakabazzar.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
      if (product.getId().equals(id)) {
        return product;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }

  @PostMapping("/sabakabazzar/cart/addToCart")
  public ResponseEntity<Object> addToCart(@RequestBody CartItems cartItems) {
    cartRepository.save(cartItems);
    return new ResponseEntity(
        new Response("success", "Product added to cart successfully"), HttpStatus.OK);
  }

  @DeleteMapping("/sabakabazzar/cart/item")
  public void deleteProduct(@RequestParam(value = "id") String id) {
    Iterator iterator = cartRepository.findAll().iterator();
    while (iterator.hasNext()) {
      CartItems product = (CartItems) iterator.next();
      if (product.getId().equals(id)) {
        cartRepository.delete(product);
        return;
      }
    }
    throw new RecordNotFoundException("This user is not exits");
  }
}
