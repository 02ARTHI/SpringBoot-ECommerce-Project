package com.ecommerce.sb_ecom.payload;

public class APIResponse {

	
	private String msg;
	private Boolean status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public APIResponse(String msg, Boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}
	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "APIResponse [msg=" + msg + ", status=" + status + "]";
	}
	
	
}
