package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.CustomerEntity;
import com.helloworld.model.Customer;
import com.helloworld.model.CustomerInfo;
import com.helloworld.model.Transaction;

@Service
public class CustomerTranslator  extends AbstractModelTranslator<CustomerEntity, Customer>  {

	@Override
	public Customer translate(CustomerEntity original) {
		if (original != null) {
			Customer customer = new  Customer();
			CustomerInfo customerInfo = new CustomerInfo(original.getCustomerId(),original.getFirstName(),original.getLastName(),original.getAddress(),original.getPhoneNumber());
			customer.setCustomberId(original.getCustomerId());
			customer.setCustomberInfo(customerInfo);
			original.getTransactions().forEach(transactionEntity -> {
				Transaction  transaction = new Transaction(transactionEntity.getTransactionId(),transactionEntity.getTransactionName(),transactionEntity.getAmount());
				customer.getTransactions().add(transaction);
			});
			return customer;
		}
		return null;
	}
}
