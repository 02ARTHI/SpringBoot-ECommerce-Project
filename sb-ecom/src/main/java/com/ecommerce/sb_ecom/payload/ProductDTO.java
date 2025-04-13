package com.ecommerce.sb_ecom.payload;

public class ProductDTO {

	private Long productId;
	private String productName;
	private String description;
	private String image;
	private int quantity;
	private double price;
	private double discount;
	private double specialPrice;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(double specialPrice) {
		this.specialPrice = specialPrice;
	}
	public ProductDTO(Long productId, String productName, String description, String image, int quantity, double price,
			double discount, double specialPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.specialPrice = specialPrice;
	}
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", image=" + image + ", quantity=" + quantity + ", price=" + price + ", discount=" + discount
				+ ", specialPrice=" + specialPrice + "]";
	}
	
	
}
