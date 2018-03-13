package com.helloworld.feign.external;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.helloworld.model.ExternalUser;
@Component
public class ExternalClientFallbackImpl implements ExternalClient {

	@Override
	public List<ExternalUser> getExternalUsers() {
		
		System.out.println("FAllback is being called");
		return new ArrayList<ExternalUser>();
	}

}
