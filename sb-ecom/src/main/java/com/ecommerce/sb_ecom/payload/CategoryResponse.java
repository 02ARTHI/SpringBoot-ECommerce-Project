package com.ecommerce.sb_ecom.payload;

import java.util.List;

public class CategoryResponse {

	private List<CategoryDTO> content;

	private int PageNumber;
	private int PageSize;
	private Long totalElements;
	private int totalPages;
	private Boolean lastpage;
	public List<CategoryDTO> getContent() {
		return content;
	}
	public void setContent(List<CategoryDTO> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Boolean getLastpage() {
		return lastpage;
	}
	public void setLastpage(Boolean lastpage) {
		this.lastpage = lastpage;
	}
	public CategoryResponse(List<CategoryDTO> content, int pageNumber, int pageSize, Long totalElements, int totalPages,
			Boolean lastpage) {
		super();
		this.content = content;
		PageNumber = pageNumber;
		PageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastpage = lastpage;
	}
	public CategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryResponse [content=" + content + ", PageNumber=" + PageNumber + ", PageSize=" + PageSize
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", lastpage=" + lastpage + "]";
	}
	
	
	
}
