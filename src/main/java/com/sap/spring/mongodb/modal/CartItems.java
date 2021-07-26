package com.sap.spring.mongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

@Document
public class CartItems extends ProductDetails {

  @Min(1)
  private int qty = 1;

  public CartItems() {}

  public CartItems(
      String productId,
      String name,
      String description,
      String imageURL,
      long price,
      long stock,
      String category,
      String sku,
      int qty) {
    super(productId, name, description, imageURL, price, stock, category, sku);
    this.qty = qty;
  }

  public int getQty() {
    return qty;
  }

  public CartItems setQty(int qty) {
    this.qty = qty;
    return this;
  }
}
