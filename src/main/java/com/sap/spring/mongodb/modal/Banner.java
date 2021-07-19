package com.sap.spring.mongodb.modal;

import org.springframework.stereotype.Component;

@Component
public class Banner {
  String bannerImageUrl;
  String bannerImageAlt;
  String isActive;
  Integer order = 2;
  String id;

  public Banner() {
  }

  public Banner(String bannerImageUrl, String bannerImageAlt, String isActive, Integer order, String id) {
    this.bannerImageUrl = bannerImageUrl;
    this.bannerImageAlt = bannerImageAlt;
    this.isActive = isActive;
    this.order = order;
    this.id = id;
  }

  public String getBannerImageUrl() {
    return bannerImageUrl;
  }

  public Banner setBannerImageUrl(String bannerImageUrl) {
    this.bannerImageUrl = bannerImageUrl;
    return this;
  }

  public String getBannerImageAlt() {
    return bannerImageAlt;
  }

  public Banner setBannerImageAlt(String bannerImageAlt) {
    this.bannerImageAlt = bannerImageAlt;
    return this;
  }

  public String getIsActive() {
    return isActive;
  }

  public Banner setIsActive(String isActive) {
    this.isActive = isActive;
    return this;
  }

  public Integer getOrder() {
    return order;
  }

  public Banner setOrder(Integer order) {
    this.order = order;
    return this;
  }

  public String getId() {
    return id;
  }

  public Banner setId(String id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Banner{" +
            "bannerImageUrl='" + bannerImageUrl + '\'' +
            ", bannerImageAlt='" + bannerImageAlt + '\'' +
            ", isActive='" + isActive + '\'' +
            ", order=" + order +
            ", id='" + id + '\'' +
            '}';
  }
}
