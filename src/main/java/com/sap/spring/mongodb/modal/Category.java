package com.sap.spring.mongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
public class Category {
  @Id private String id;
  private String categoryId;
  private String name;
  private String key;
  private String description;
  private boolean enabled;
  private Integer order;
  private String imageUrl;

  public Category() {}

  public Category(
      String categoryId,
      String name,
      String key,
      String description,
      boolean enabled,
      Integer order,
      String imageUrl) {
    this.categoryId = categoryId;
    this.name = name;
    this.key = key;
    this.description = description;
    this.enabled = enabled;
    this.order = order;
    this.imageUrl = imageUrl;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public Category setCategoryId(String categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public String getName() {
    return name;
  }

  public Category setName(String name) {
    this.name = name;
    return this;
  }

  public String getKey() {
    return key;
  }

  public Category setKey(String key) {
    this.key = key;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Category setDescription(String description) {
    this.description = description;
    return this;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public Category setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  public Integer getOrder() {
    return order;
  }

  public Category setOrder(Integer order) {
    this.order = order;
    return this;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Category setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }
}
