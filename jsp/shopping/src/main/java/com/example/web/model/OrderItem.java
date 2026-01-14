package com.example.web.model;

public class OrderItem {
    private String orderItemId;
    private String orderId;
    private String productId;
    private int quantity;
    private double price; // 주문 당시 상품 단가

    // 상품 상세 정보를 추가로 가져오기 위함
    private Product product; 
    
    public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(String orderItemId, String orderId, String productId, int quantity, double price,
			Product product) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", price=" + price + ", product=" + product + "]";
	}
    
    
    
    

    
}