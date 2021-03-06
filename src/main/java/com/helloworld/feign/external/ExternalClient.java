package com.helloworld.feign.external;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloworld.model.ExternalUser;

@FeignClient(name = "external-user-service-client", url = "https://jsonplaceholder.typicode.com" , fallback=ExternalClientFallbackImpl.class)
public interface ExternalClient {

	@RequestMapping(method = RequestMethod.GET, value = "/posts")
	public List<ExternalUser> getExternalUsers();

}
