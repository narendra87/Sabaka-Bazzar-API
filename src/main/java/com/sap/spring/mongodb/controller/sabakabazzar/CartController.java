package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.cutomexception.RecordNotFoundException;
import com.sap.spring.mongodb.modal.CartItems;
import com.sap.spring.mongodb.repository.sabakabazzar.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
  public CartItems getCartItem(@RequestParam(value = "productId") String productId) {
    Iterator iterator = cartRepository.findAll().iterator();
    while (iterator.hasNext()) {
      CartItems product = (CartItems) iterator.next();
      if (product.getProductId().equals(productId)) {
        return product;
      }
    }
    throw new RecordNotFoundException("This product is not exits");
  }

  @PostMapping("/sabakabazzar/cart/addToCart")
  public List<CartItems> addToCart(@RequestBody @Validated CartItems cartItem) {
    if (cartRepository.findAll().size() > 0) {
      Iterator iterator = cartRepository.findAll().iterator();
      while (iterator.hasNext()) {
        CartItems product = (CartItems) iterator.next();
        if (product.getProductId().equals(cartItem.getProductId())) {
          cartRepository.delete(product);
          product.setQty(product.getQty() + 1);
          cartRepository.save(product);
          return cartRepository.findAll();
        }
      }
    }
    cartRepository.save(cartItem);
    return cartRepository.findAll();
  }

  @DeleteMapping("/sabakabazzar/cart/deleteToCart")
  public List<CartItems> deleteToCart(@RequestParam(value = "productId") String productId) {
    Iterator iterator = cartRepository.findAll().iterator();
    while (iterator.hasNext()) {
      CartItems product = (CartItems) iterator.next();
      if (product.getProductId().equals(productId)) {
        if (product.getQty() > 1) {
          cartRepository.delete(product);
          product.setQty(product.getQty() - 1);
          cartRepository.save(product);
          return cartRepository.findAll();
        } else {
          cartRepository.delete(product);
          return cartRepository.findAll();
        }
      }
    }
    throw new RecordNotFoundException("This product is not exits");
  }

  @DeleteMapping("/sabakabazzar/cart/clearCart")
  public void clearCart() {
    cartRepository.deleteAll();
  }
}
