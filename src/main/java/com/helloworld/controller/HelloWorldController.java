package com.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.model.Customber;
import com.helloworld.model.ExternalUser;
import com.helloworld.model.Transaction;
import com.helloworld.services.HelloWorldService;
import com.helloworld.threadDeadLock.TestDeadlock;



@RestController
public class HelloWorldController implements HelloWorldControllerService {

	@Autowired
	HelloWorldService helloWorldService;

	@Override
	public Customber createCustomer(Customber customber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customber updateCustomer(Customber customber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customber> getAllCustombers() {
		return helloWorldService.getAllCustombers();
	}

	@Override
	public Customber getCustomber(@PathVariable(value="customberId") int customberId) {
		return helloWorldService.getAllCustomberById(customberId);
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
		TestDeadlock  testDeadlock = new TestDeadlock();
		testDeadlock.trd1.start();
		testDeadlock.trd2.start();
		return	testDeadlock.getOutPut();

	}

}
