package com.ecommerce.sb_ecom.payload;

import java.util.List;

public class ProductResponse {

	private List<ProductDTO> content;

	public List<ProductDTO> getContent() {
		return content;
	}

	public void setContent(List<ProductDTO> content) {
		this.content = content;
	}

	public ProductResponse(List<ProductDTO> content) {
		super();
		this.content = content;
	}

	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductResponse [content=" + content + "]";
	}
	
	
}
