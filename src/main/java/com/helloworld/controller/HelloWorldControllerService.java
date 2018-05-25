package com.helloworld.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.helloworld.model.Customer;
import com.helloworld.model.CustomerInfo;
import com.helloworld.model.ExternalUser;
import com.helloworld.model.Transaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("Store application which allow create customber accounts and create and maintain transactions for customers.")

public interface  HelloWorldControllerService {

	/*@ApiOperation(value = "Gets all Customers Details.")
	@GetMapping(value = "/customers")
	List<Customer> getAllCustomers();*/

	@ApiOperation(value = "Gets Customer Details with the specified customer ID .")
	@GetMapping(value = "/customer/{customerId}")
	Customer getCustomber(@PathVariable(value="customerId") int customberId);

	@PostMapping(value = "/customer")
	@ApiOperation(value = "Creates new Customer with information provided.")
	CustomerInfo createCustomer(@RequestBody CustomerInfo  customerInfo);

	@PutMapping(value = "/customer/{customerId}")
	@ApiOperation(value = "Update Existing Customer with information provided.")
	CustomerInfo updateCustomer(@PathVariable(value="customerId") int customerId ,@RequestBody CustomerInfo  customerInfo);

	@PostMapping(value = "/customer/{customerId}/transaction")
	@ApiOperation(value = "Add new transaction to existing Customer.")
	Transaction addTransaction(@PathVariable(value="customerId") int customerId ,@RequestBody Transaction transaction);

	@PutMapping(value = "/customer/transaction/{transactionId}")
	@ApiOperation(value = "Update Existing Transaction with information provided..")
	Transaction updateTransaction(@PathVariable(value="transactionId") long transactionId , @RequestBody Transaction transaction);

	@ApiOperation(value = "Delete Customer Details with all transactions.")
	@DeleteMapping(value = "/customer/{customerId}")
	boolean deleteCustomber(@PathVariable(value="customerId") int customberId);

	@ApiOperation(value = "Delete Transaction.")
	@DeleteMapping(value = "/customer/transaction/{transactionId}")
	boolean deleteTransaction(@PathVariable(value="transactionId") long transactionId);

	@GetMapping(value = "/fibo/{num}")
	@ApiOperation(value = "Get fibonacci series")
	Long[] getFibonacciSeries(@PathVariable(value = "num") int num);

	@ApiOperation(value = "Get USers from https://jsonplaceholder.typicode.com/posts service")
	@GetMapping(value = "/externalUsers")
	List <ExternalUser> getExternalUsers();

	@ApiOperation(value = "This will crate Deadlock for two Threads.")
	@GetMapping(value = "/thredDeadLock")
	String thredDeadLock();
}
