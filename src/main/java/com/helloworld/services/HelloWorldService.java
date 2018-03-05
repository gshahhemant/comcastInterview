package com.helloworld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.helloworld.exception.HelloWorldException;
import com.helloworld.exception.HelloWorldExceptionCode;
import com.helloworld.feign.external.ExternalClient;
import com.helloworld.jpa.model.AppEntity;
import com.helloworld.model.AppInfo;
import com.helloworld.model.ExternalUser;
import com.helloworld.repository.AppDetailRepository;
import com.helloworld.translator.AppTranslator;
import com.helloworld.validator.Validator;

/**
 * @author Hemant Shah
 */

@Service
public class HelloWorldService {

	@Autowired
	AppDetailRepository  appDetailRepository;

	@Autowired
	ExternalClient  externalClient;

	@Autowired
	AppTranslator  appTranslator;

	@Autowired
	Validator validator;

	public List<AppInfo> getAllApps() {

		List<AppEntity> appEntities = appDetailRepository.getAllApps();

		if (appEntities == null || appEntities.isEmpty())
			throw new HelloWorldException(HelloWorldExceptionCode.NO_APPS_FOUND);
		else
			return appTranslator.translate(appEntities);
	}

	public AppInfo getApp(int appId) {

		if(appId < 0) {
			throw new HelloWorldException(HelloWorldExceptionCode.INVALID_APPID);
		}

		AppEntity appEntity = appDetailRepository.getAppById(appId);

		if (appEntity == null )
			throw new HelloWorldException(HelloWorldExceptionCode.NO_APPS_FOUND);
		else
			return appTranslator.translate(appEntity);

	}

	public AppInfo createApp(AppInfo appInfo) {


		if (!validator.appValidation(appInfo)){

			throw new HelloWorldException(HelloWorldExceptionCode.INPUT_FIELD_VALIDATION_FAILED);
		}

		AppEntity appEntity =appTranslator.translateToAppEntity(appInfo);

		appDetailRepository.save(appEntity);

		appInfo.setAppId(appEntity.getAppId());

		return appInfo;
	}

	public AppInfo updateApp(int appId, @RequestBody AppInfo appInfo) {

		if (!validator.appValidation(appInfo)){

			throw new HelloWorldException(HelloWorldExceptionCode.INPUT_FIELD_VALIDATION_FAILED);
		}

		AppEntity appEntity = appDetailRepository.getAppById(appId);

		if(appEntity == null) {

			throw new HelloWorldException(HelloWorldExceptionCode.NO_APPS_FOUND);
		}else {
			appEntity =appTranslator.translateAppToUpdate(appEntity,appInfo);
			appDetailRepository.save(appEntity);
			appInfo.setAppId(appEntity.getAppId());
		}

		return appInfo;
	}

	public boolean deleteApp(int appId) {

		if(appId < 0) {
			throw new HelloWorldException(HelloWorldExceptionCode.INVALID_APPID);
		}

		AppEntity appEntity = appDetailRepository.getAppById(appId);

		if(appEntity == null) 

			throw new HelloWorldException(HelloWorldExceptionCode.NO_APPS_FOUND);
		else
			appDetailRepository.delete(appEntity);

		return true;
	}

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

}
