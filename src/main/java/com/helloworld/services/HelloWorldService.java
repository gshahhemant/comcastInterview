package com.helloworld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.exception.HelloWorldException;
import com.helloworld.exception.HelloWorldExceptionCode;
import com.helloworld.feign.external.ExternalClient;
import com.helloworld.jpa.model.CustomerEntity;
import com.helloworld.jpa.model.TransactionEntity;
import com.helloworld.model.Customer;
import com.helloworld.model.CustomerInfo;
import com.helloworld.model.ExternalUser;
import com.helloworld.model.Transaction;
import com.helloworld.repository.CustomerRepository;
import com.helloworld.repository.TransactionRepository;
import com.helloworld.translator.CustomerEntityTranslator;
import com.helloworld.translator.CustomerTranslator;
import com.helloworld.translator.TransactionEntityTranslator;
import com.helloworld.translator.TransactionTranslator;

@Service
public class HelloWorldService {

	@Autowired
	CustomerRepository  customerRepository;

	@Autowired
	TransactionRepository  transactionRepository;

	@Autowired
	ExternalClient  externalClient;

	@Autowired
	CustomerTranslator customerTranslator;

	@Autowired
	TransactionTranslator transactionTranslator;

	@Autowired
	TransactionEntityTranslator transactionEntityTranslator;

	@Autowired
	CustomerEntityTranslator customerEntityTranslator;


	/**
	 * Create Customer 
	 * @return The CustomerInfo
	 */
	public CustomerInfo createCustomer(CustomerInfo customerInfo) {

		CustomerEntity customberEntity = customerEntityTranslator.translate(customerInfo);
		if (customberEntity != null) {
			customerRepository.save(customberEntity);
			customerInfo.setCustomberId(customberEntity.getCustomerId());
		}
		return customerInfo;
	}

	/**
	 * Update Customer 
	 * @return The CustomerInfo
	 */
	public CustomerInfo updateCustomer(int customberId , CustomerInfo customerInfo) {

		CustomerEntity  customberEntity = customerRepository.findOne(customberId);
		if (customberEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);

		customerEntityTranslator.translateUpdate(customerInfo, customberEntity);
		customerRepository.save(customberEntity);
		customerInfo.setCustomberId(customberEntity.getCustomerId());
		return customerInfo;
	}

	/**
	 * Add transaction to existing customer 
	 * @return added Transaction
	 */
	public   Transaction addTransaction(int customberId ,Transaction transaction) {
		CustomerEntity  customberEntity = customerRepository.findOne(customberId);
		if (customberEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);
		else {
			TransactionEntity  TransactionEntity = transactionEntityTranslator.translate(transaction);
			if(TransactionEntity != null) {
				TransactionEntity.setCustomer(customberEntity);
				transactionRepository.save(TransactionEntity);
				transaction.setTransactionId(TransactionEntity.getTransactionId());
			}
		}
		return transaction;
	}

	/**
	 * Update transaction details 
	 * @return updated Transaction
	 */
	public Transaction updateTransaction(long transactionId , Transaction transaction) {
		TransactionEntity  transactionEntity = transactionRepository.findOne(transactionId);
		if (transactionEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_TRANSACTION_FOUND);

		transactionTranslator.translateUpdate(transaction, transactionEntity);
		transactionRepository.save(transactionEntity);
		transaction.setTransactionId(transactionEntity.getTransactionId());
		return transaction;
	}

	/**
	 * Get All customers with transactions details 
	 * @return List of Customers
	 */
	public List<Customer> getAllCustomers() {

		List<CustomerEntity>  customerEntities = customerRepository.getAllCustombers();
		if (customerEntities == null || customerEntities.isEmpty())
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);
		else
			return customerTranslator.translate(customerEntities);
	}

	/**
	 * Get specific customer with transactions details 
	 * @return Customers
	 */
	public Customer getAllCustomerById(int  customberId) {

		CustomerEntity  customberEntity = customerRepository.getCustomberById(customberId);

		if (customberEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);
		else
			return customerTranslator.translate(customberEntity);

	}

	/**
	 * Delete specific customer and customer's transactions  
	 * @return true if deleted successfully
	 */
	public boolean deleteCustomer(int customberId) {
		CustomerEntity  customerEntity = customerRepository.findOne(customberId);
		if (customerEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);

		customerRepository.delete(customberId);
		return true;
	}

	/**
	 * Delete specific transaction  
	 * @return true if deleted successfully
	 */
	public boolean deleteTransaction(long transactionId) {
		TransactionEntity  transactoinEntity = transactionRepository.findOne(transactionId);
		if (transactoinEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_TRANSACTION_FOUND);

		transactionRepository.delete(transactionId);
		return true;
	}

	/**
	 * Get FibonacciSeries up to given numbers   
	 * @return number array with all series numbers
	 */
	public Long[] getFibonacciSeries(int num) {

		FibeSeries fibeSeries = new FibeSeries(num);

		return fibeSeries.getFibonacciSeries(num); 

	}

	/**
	 * Get Users data from https://jsonplaceholder.typicode.com/post API.   
	 * @return List of users
	 */
	public List <ExternalUser> getExternalUsers()
	{
		List <ExternalUser>  externalUsers=  externalClient.getExternalUsers();

		if(externalUsers == null || externalUsers.isEmpty())
			throw new HelloWorldException(HelloWorldExceptionCode.NO_USERS_FOUND);
		else
			return externalUsers;
	}

}
