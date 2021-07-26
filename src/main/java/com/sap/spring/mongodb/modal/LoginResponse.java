package com.sap.spring.mongodb.modal;

public class LoginResponse extends Response{
    private int cartCount;

    public LoginResponse(int cartCount,String response, String responseMessage) {
        super(response,responseMessage);
        this.cartCount = cartCount;
    }

    public int getCartCount() {
        return cartCount;
    }

    public LoginResponse setCartCount(int cartCount) {
        this.cartCount = cartCount;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "cartCount=" + cartCount +
                '}';
    }
}
