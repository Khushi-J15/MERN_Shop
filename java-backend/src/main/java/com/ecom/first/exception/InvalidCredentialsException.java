package com.ecom.first.exception;

public class InvalidCredentialsException extends RuntimeException{
	
	public InvalidCredentialsException(String message){
		super(message);
	}
}
