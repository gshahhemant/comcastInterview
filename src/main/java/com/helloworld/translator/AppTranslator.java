package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.AppEntity;
import com.helloworld.model.AppInfo;


/**
 * @author Hemant Shah
 */
@Service
public class AppTranslator extends AbstractModelTranslator<AppEntity, AppInfo> {

	@Override
	public AppInfo translate(AppEntity original) {

		AppInfo appInfo= null;

		if(original != null) {

			appInfo = new  AppInfo(original.getAppId(),original.getName(),original.getPublisherName(),original.getPublisherCompanyName(),original.getMajorVersion(),original.getMinorVersion(),original.getPatchVersion(),original.getShortDescription(),original.getLongDescription());
		}

		return  appInfo;
	}
	
	public AppEntity translateToAppEntity(AppInfo appInfo) {

		AppEntity appEntity= null;

		if(appInfo != null) {

			 appEntity = new  AppEntity (appInfo.getName(),appInfo.getPublisherName(),appInfo.getPublisherCompanyName()
					,appInfo.getMajorVersion(),appInfo.getMinorVersion(),appInfo.getPatchVersion(),appInfo.getShortDescription()
					,appInfo.getLongDescription());
		}

		return  appEntity;
	}
	public AppEntity translateAppToUpdate(AppEntity appEntity,AppInfo appInfo) {

		if(appInfo != null) {
			 
			 appEntity.setName(appInfo.getName());
			 appEntity.setPublisherName(appInfo.getPublisherName());
			 appEntity.setPublisherCompanyName(appInfo.getPublisherCompanyName());
			 appEntity.setShortDescription(appInfo.getShortDescription());
			 appEntity.setLongDescription(appInfo.getLongDescription());
			 appEntity.setMajorVersion(appInfo.getMajorVersion());
			 appEntity.setMinorVersion(appInfo.getMinorVersion());
			 appEntity.setPatchVersion(appInfo.getPatchVersion());
		}

		return  appEntity;
	}

}
