package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.CustomerEntity;
import com.helloworld.model.CustomerInfo;

@Service
public class CustomerEntityTranslator  extends AbstractModelTranslator<CustomerInfo,CustomerEntity >  {

	@Override
	public CustomerEntity translate(CustomerInfo original) {

		CustomerEntity customberEntity = null;
		if (original != null) {
			customberEntity = new CustomerEntity(original.getFirstName(),original.getLastName(),original.getAddress(),original.getPhoneNumber());
		}
		return  customberEntity;
	}

	public void translateUpdate(CustomerInfo customerInfo, CustomerEntity customberEntity) {

		if (customerInfo != null) {
			customberEntity.setFirstName(customerInfo.getFirstName());
			customberEntity.setLastName(customerInfo.getLastName());
			customberEntity.setAddress(customerInfo.getAddress());
			customberEntity.setPhoneNumber(customerInfo.getPhoneNumber());
		}
	}
}
