package com.sap.spring.mongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document
public class ProductDetails {
  @Id
  private String id;
  @NotEmpty private String productId;
  @NotEmpty private String name;
  private String description;
  private String imageURL;
  private long price;
  private long stock;
  @NotEmpty private String category;
  @NotEmpty private String sku;

  public ProductDetails() {}

  public ProductDetails(
      String productId,
      String name,
      String description,
      String imageURL,
      long price,
      long stock,
      String category,
      String sku) {
    this.productId = productId;
    this.name = name;
    this.description = description;
    this.imageURL = imageURL;
    this.price = price;
    this.stock = stock;
    this.category = category;
    this.sku = sku;
  }

  public String getProductId() {
    return productId;
  }

  public ProductDetails setProductId(String productId) {
    this.productId = productId;
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
        + " productId='"
        + productId
        + '\''
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
