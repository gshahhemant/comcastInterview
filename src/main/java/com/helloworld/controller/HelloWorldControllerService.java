package com.helloworld.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.helloworld.model.Customber;
import com.helloworld.model.ExternalUser;
import com.helloworld.model.Transaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("The application catalog service is used to return apps and apps versions")
public interface  HelloWorldControllerService {

		
	@ApiOperation(value = "Gets all Custombers Details.")
	@GetMapping(value = "/custombers")
	List<Customber> getAllCustombers();
	
	@ApiOperation(value = "Gets Customber Details with the specified customber ID .")
	@GetMapping(value = "/customber/{customberId}")
	Customber getCustomber(@PathVariable(value="customberId") int customberId);

	@PostMapping(value = "/customber")
	@ApiOperation(value = "Creates New Customber with information provided.")
	Customber createCustomer(@RequestBody Customber  customber);
	
	@PutMapping(value = "/customber")
	@ApiOperation(value = "Update Existing Customber with information provided.")
	Customber updateCustomer(@RequestBody Customber  customber);

	@PostMapping(value = "/customber/{customberId}/transaction")
	@ApiOperation(value = "Add new transaction to existing Customber.")
	Transaction createTransaction(@RequestBody Transaction transaction);
		
	@GetMapping(value = "/fibo/{num}")
	@ApiOperation(value = "Get fibonacci series")
	Long[] getFibonacciSeries(@PathVariable(value = "num") int num);

	@GetMapping(value = "/externalUsers")
	@ApiOperation(value = "Get USers from https://jsonplaceholder.typicode.com/posts service")
	List <ExternalUser> getExternalUsers();

	@ApiOperation(value = "thredDeadLock.")
	@GetMapping(value = "/thredDeadLock")
	String thredDeadLock();

}
