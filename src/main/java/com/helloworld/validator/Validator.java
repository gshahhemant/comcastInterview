package com.helloworld.validator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.helloworld.exception.HelloWorldException;
import com.helloworld.exception.HelloWorldExceptionCode;
import com.helloworld.model.CustomerInfo;



@Component
public class Validator implements org.springframework.validation.Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerInfo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "001");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "002");
			
		CustomerInfo customerInfo = (CustomerInfo)target;
		
		if (customerInfo.getPhoneNumber()==6783946538l) {
			errors.rejectValue("phoneNumber", "PH001","phone number is invalid");
		}

	}

}
