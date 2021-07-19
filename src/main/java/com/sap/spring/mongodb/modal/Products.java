package com.sap.spring.mongodb.modal;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Products {
    private ArrayList<ProductDetails> products;

    public Products() {
    }

    public Products(ArrayList<ProductDetails> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + products +
                '}';
    }
}
