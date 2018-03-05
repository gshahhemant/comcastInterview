package com.helloworld.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.helloworld.model.AppInfo;
import com.helloworld.model.ExternalUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Hemant Shah
 */

@Api("The application catalog service is used to return apps and apps versions")
public interface  HelloWorldControllerService {


	@ApiOperation(value = "Gets all Apps Details.")
	@GetMapping(value = "/apps")
	List<AppInfo> getAllApps();

	@ApiOperation(value = "Gets all Apps with the specified App ID.")
	@GetMapping(value = "/apps/{appId}")
	AppInfo getApp(@PathVariable(value = "appId") int appId);

	@PostMapping(value = "/apps")
	@ApiOperation(value = "Creates  App using the information provided.")
	AppInfo createApp(@RequestBody AppInfo appInfo);

	@PutMapping(value = "/apps/{appId}")
	@ApiOperation(value = "Updates the specified App  with the information provided.")
	AppInfo updateApp(@PathVariable("appId") int appId, @RequestBody AppInfo appInfo);

	@DeleteMapping(value = "apps/{appId}")
	@ApiOperation(value = "Deletes the specified App from the catalog")
	boolean deleteApp(@PathVariable(value = "appId") int appId);

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
