package com.helloworld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.exception.HelloWorldException;
import com.helloworld.exception.HelloWorldExceptionCode;
import com.helloworld.feign.external.ExternalClient;
import com.helloworld.jpa.model.CustomberEntity;
import com.helloworld.model.Customber;
import com.helloworld.model.ExternalUser;
import com.helloworld.repository.CustomberRepository;
import com.helloworld.translator.CustomberTranslator;

@Service
public class HelloWorldService {

	@Autowired
	CustomberRepository  customberRepository;

	@Autowired
	ExternalClient  externalClient;
	
	@Autowired
	CustomberTranslator customberTranslator;

	public Long[] getFibonacciSeries(int num) {

		FibeSeries fibeSeries = new FibeSeries(num);

		return fibeSeries.getFibonacciSeries(num); 

	}

	public List <ExternalUser> getExternalUsers()
	{
		List <ExternalUser>  externalUsers=  externalClient.getExternalUsers();

		if(externalUsers == null || externalUsers.isEmpty())
			throw new HelloWorldException(HelloWorldExceptionCode.NO_USERS_FOUND);
		else
			return externalUsers;
	}

	public List<Customber> getAllCustombers() {

		List<CustomberEntity>  customerEntities = customberRepository.getAllCustombers();

		if (customerEntities == null || customerEntities.isEmpty())
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);
		else
			return customberTranslator.translate(customerEntities);

	}

	public Customber getAllCustomberById(int  customberId) {

		CustomberEntity  customberEntity = customberRepository.getCustomberById(customberId);

		if (customberEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_CUSTOMBER_FOUND);
		else
			return customberTranslator.translate(customberEntity);

	}
	
}
