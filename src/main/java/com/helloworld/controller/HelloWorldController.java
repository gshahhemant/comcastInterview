			package com.helloworld.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.model.Customer;
import com.helloworld.model.CustomerInfo;
import com.helloworld.model.ExternalUser;
import com.helloworld.model.Transaction;
import com.helloworld.services.HelloWorldService;
import com.helloworld.validator.Validator;
import com.helloworld.validator.ValidatorSecond;


@RestController
@RequestMapping(value = "/services")
public class HelloWorldController  {

		
	@Autowired
	HelloWorldService helloWorldService;
	
	@Autowired
	Validator validator;
	
	@Autowired
	ValidatorSecond validatorSecond;
	
	@InitBinder("customerInfo")
	protected void initCustomerInfoBinder(WebDataBinder binder) {
	    binder.addValidators(validator);
	   
	}
	@InitBinder("transaction")
	protected void initTransactionBinder(WebDataBinder binder) {
	  
	    binder.addValidators(validatorSecond);
	}

	/*@Override
	public CustomerInfo createCustomer( @Valid @RequestBody CustomerInfo customerInfo){
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
*/
	@RequestMapping(value = "/customers" , method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return helloWorldService.getAllCustomers();
	}

	/*@Override
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
	}*/
}
