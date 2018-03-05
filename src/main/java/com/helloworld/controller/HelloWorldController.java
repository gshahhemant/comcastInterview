package com.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.model.AppInfo;
import com.helloworld.model.ExternalUser;
import com.helloworld.services.HelloWorldService;
import com.helloworld.threadDeadLock.TestDeadlock;

/**
 * @author Hemant Shah
 */

@RestController
public class HelloWorldController implements HellowWorldService {

	@Autowired
	HelloWorldService helloWorldService;



	@Override
	public List<AppInfo> getAllApps() {
		return helloWorldService.getAllApps();
	}

	@Override
	public AppInfo getApp(@PathVariable(value = "appId") int appId) {

		return helloWorldService.getApp(appId);
	}

	@Override
	public AppInfo createApp(@RequestBody AppInfo appInfo) {

		return helloWorldService.createApp(appInfo);
	}

	@Override
	public AppInfo updateApp(@PathVariable("appId") int appId, @RequestBody AppInfo appInfo) {
		return helloWorldService.updateApp(appId, appInfo);
	}

	@Override
	public boolean deleteApp(@PathVariable("appId") int appId) {
		return helloWorldService.deleteApp(appId);
	}


	@Override
	public int[] getFibonacciSeries(@PathVariable("num") int num) {
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
