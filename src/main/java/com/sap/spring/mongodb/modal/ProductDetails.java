package com.sap.spring.mongodb.modal;

import org.springframework.stereotype.Component;

@Component
public class ProductDetails {
  private String id;
  private String name;
  private String description;
  private String imageURL;
  private long price;
  private long stock;
  private String category;
  private String sku;

  public ProductDetails() {}

  public ProductDetails(
      String  id,
      String name,
      String description,
      String imageURL,
      long price,
      long stock,
      String category,
      String sku) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageURL = imageURL;
    this.price = price;
    this.stock = stock;
    this.category = category;
    this.sku = sku;
  }

  public String  getId() {
    return id;
  }

  public ProductDetails setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ProductDetails setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ProductDetails setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getImageURL() {
    return imageURL;
  }

  public ProductDetails setImageURL(String imageURL) {
    this.imageURL = imageURL;
    return this;
  }

  public long getPrice() {
    return price;
  }

  public ProductDetails setPrice(long price) {
    this.price = price;
    return this;
  }

  public long getStock() {
    return stock;
  }

  public ProductDetails setStock(long stock) {
    this.stock = stock;
    return this;
  }

  public String getCategory() {
    return category;
  }

  public ProductDetails setCategory(String category) {
    this.category = category;
    return this;
  }

  public String getSku() {
    return sku;
  }

  public ProductDetails setSku(String sku) {
    this.sku = sku;
    return this;
  }

  @Override
  public String toString() {
    return "ProductDetails{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", imageURL='"
        + imageURL
        + '\''
        + ", price="
        + price
        + ", stock="
        + stock
        + ", category='"
        + category
        + '\''
        + ", sku='"
        + sku
        + '\''
        + '}';
  }
}
