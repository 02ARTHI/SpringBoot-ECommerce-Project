package com.ecommerce.sb_ecom.exceptions;

public class ApiException extends RuntimeException {

	
	public ApiException()
	{
		
	}
	
	public ApiException(String message)
	{
		super(message);
	}
}
