package com.sap.spring.mongodb.modal;

import org.springframework.stereotype.Component;

@Component
public class Category {
    private String id;
    private String name;
    private String key;
    private String description;
    private boolean enabled;
    private Integer order;
    private String imageUrl;

    public Category() {
    }

    public Category(String id, String name, String key, String description, boolean enabled, Integer order, String imageUrl) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.description = description;
        this.enabled = enabled;
        this.order = order;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public Category setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", order=" + order +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
