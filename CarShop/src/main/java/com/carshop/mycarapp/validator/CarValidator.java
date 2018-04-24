package com.carshop.mycarapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.carshop.mycarapp.pojo.Car;



public class CarValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(Car.class);
	}

	public void validate(Object obj, Errors errors) {
		Car car = (Car) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "error.invalid.brand", "Brand Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelNo", "error.invalid.modelNo", "Model Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "makeYear", "error.invalid.makeYear", "Make Year Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "Price Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description","description Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colorsAvailable", "error.invalid.colorsAvailable","Put colors separated by comma");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imageSrc", "error.invalid.imageSrc","Put colors separated by comma");
		// check if user exists
		
	}
}
