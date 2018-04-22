package com.carshop.mycarapp.exception;

public class CarException extends Exception {

	public CarException(String message)
	{
		super("UserException-"+message);
	}
	
	public CarException(String message, Throwable cause)
	{
		super("UserException-"+message,cause);
	}
	
}
