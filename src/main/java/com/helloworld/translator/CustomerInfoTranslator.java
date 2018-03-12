package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.CustomerEntity;
import com.helloworld.model.CustomerInfo;

@Service
public class CustomerInfoTranslator  extends AbstractModelTranslator<CustomerEntity, CustomerInfo>  {

	@Override
	public CustomerInfo translate(CustomerEntity original) {

		CustomerInfo customerInfo = null;
		
		if (original != null) {
			customerInfo = new CustomerInfo(original.getCustomerId(),original.getFirstName(),original.getLastName(),original.getAddress(),original.getPhoneNumber());
		}
		return customerInfo;
	}
}
