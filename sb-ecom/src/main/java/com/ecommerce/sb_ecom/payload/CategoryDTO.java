package com.ecommerce.sb_ecom.payload;

public class CategoryDTO {

	private Long CategoryId;
	private String CategoryName;
	public Long getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public CategoryDTO(Long categoryId, String categoryName) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryDTO [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + "]";
	}
	
	
}
