package com.helloworld.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.model.Customer;
import com.helloworld.model.CustomerInfo;
import com.helloworld.model.ExternalUser;
import com.helloworld.model.Transaction;
import com.helloworld.services.HelloWorldService;



@RestController
public class HelloWorldController implements HelloWorldControllerService {

	@Autowired
	HelloWorldService helloWorldService;

	@Override
	public CustomerInfo createCustomer(@Valid @RequestBody CustomerInfo customerInfo) {
		return helloWorldService.createCustomer(customerInfo);
	}

	@Override
	public CustomerInfo updateCustomer(@PathVariable(value="customerId") int customerId ,@Valid @RequestBody  CustomerInfo customerInfo) {
		return helloWorldService.updateCustomer(customerId,customerInfo);
	}

	@Override
	public Transaction addTransaction(@PathVariable(value="customerId") int customerId , @Valid @RequestBody Transaction transaction) {
		return helloWorldService.addTransaction(customerId, transaction);
	}

	@Override
	public Transaction updateTransaction(@PathVariable(value="transactionId") long transactionId , @Valid @RequestBody Transaction transaction) {
		return helloWorldService.updateTransaction(transactionId,transaction);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return helloWorldService.getAllCustomers();
	}

	@Override
	public Customer getCustomber(@PathVariable(value="customerId") int customerId) {
		return helloWorldService.getAllCustomerById(customerId);
	}

	@Override
	public boolean deleteCustomber(@PathVariable(value="customerId") int customerId) {
		return helloWorldService.deleteCustomer(customerId);
	}

	@Override
	public boolean deleteTransaction(@PathVariable(value="transactionId") long transactionId ) {
		return helloWorldService.deleteTransaction(transactionId);
	}

	@Override
	public Long[] getFibonacciSeries(@PathVariable("num") int  num) {
		return helloWorldService.getFibonacciSeries(num);
	}

	@Override
	public List<ExternalUser> getExternalUsers()
	{
		return  helloWorldService.getExternalUsers();
	}

	@Override
	public String thredDeadLock()
	{
		return helloWorldService.thredDeadLock();
	}
}
