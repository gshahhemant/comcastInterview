package com.helloworld.validator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.helloworld.model.CustomerInfo;
import com.helloworld.model.Transaction;



@Component
public class ValidatorSecond implements org.springframework.validation.Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		return Transaction.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "transactionName", "transactionName.empty");

	}

}
