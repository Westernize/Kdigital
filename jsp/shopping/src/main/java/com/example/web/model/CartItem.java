package com.example.web.model;

import java.util.Date;

public class CartItem {
    private String cartItemId;
    private String userId;
    private String productId;
    private int quantity;
    private Date addDate;

    // 상품 상세 정보를 추가로 가져오기 위함 (조인하여 사용)
    private Product product; 

    public CartItem() {}

    public CartItem(String cartItemId, String userId, String productId, int quantity, Date addDate) {
        this.cartItemId = cartItemId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.addDate = addDate;
    }

    // Getters and Setters
    public String getCartItemId() { return cartItemId; }
    public void setCartItemId(String cartItemId) { this.cartItemId = cartItemId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Date getAddDate() { return addDate; }
    public void setAddDate(Date addDate) { this.addDate = addDate; }
    
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", addDate=" + addDate + ", product=" + product + "]";
	}
    
    
}