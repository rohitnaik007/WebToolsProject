package com.carshop.mycarapp.exception;

public class CarException extends Exception {

	public CarException(String message)
	{
		super("CarException-"+message);
	}
	
	public CarException(String message, Throwable cause)
	{
		super("CarException-"+message,cause);
	}
	
}
