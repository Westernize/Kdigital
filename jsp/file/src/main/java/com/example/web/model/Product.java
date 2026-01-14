package com.example.web.model;

public class Product {
		private String productId;
		private String name;
		private double price;
		private String description;
		private int stock;
		private String imageUrl;
		
		public Product() {
			// TODO Auto-generated constructor stub //묵시적인 생성자
		}
		
		
		
		
		public Product(String productId, String name, double price, String description, int stock, String imageUrl) {
			this.productId = productId;
			this.name = name;
			this.price = price;
			this.description = description;
			this.stock = stock;
			this.imageUrl = imageUrl;
		} //명시적인 생성자




		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", description="
					+ description + ", stock=" + stock + ", imageUrl=" + imageUrl + "]";
		}
		
		
		
		
}
