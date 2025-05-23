package com.ecommerce.sb_ecom.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.sb_ecom.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String, String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            response.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(response,
                HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> myResourceNotFoundException (ResourceNotFoundException e){
		
		String msg=e.getMessage();
		APIResponse apiresponse = new APIResponse(msg, false);
		return new ResponseEntity<APIResponse>(apiresponse,HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(ApiException.class)
    public ResponseEntity<APIResponse> myApiException (ApiException e){
		
		String msg=e.getMessage();
		APIResponse apiresponse = new APIResponse(msg, false);
		return new ResponseEntity<APIResponse>(apiresponse,HttpStatus.BAD_REQUEST);
	
	}
}
