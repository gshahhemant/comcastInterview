package com.helloworld.model;

import java.io.Serializable;


/**
 * @author Hemant Shah
 */

public class AppInfo implements Serializable {

	private static final long serialVersionUID = -4450513721784577290L;

	private int appId;
	private String name;
	private String publisherName;
	private String publisherCompanyName;
	private int majorVersion;
	private int minorVersion;
	private int patchVersion;
	private String shortDescription;
	private String longDescription;
	
	public  AppInfo() {
		
	}

	public AppInfo(int appId, String name, String publisherName, String publisherCompanyName, int majorVersion,
			int minorVersion, int patchVersion, String shortDescription, String longDescription) {
		this.appId = appId;
		this.name = name;
		this.publisherName = publisherName;
		this.publisherCompanyName = publisherCompanyName;
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
		this.patchVersion = patchVersion;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
	
	public AppInfo(String name, String publisherName, String publisherCompanyName, int majorVersion,
			int minorVersion, int patchVersion, String shortDescription, String longDescription) {

		this.name = name;
		this.publisherName = publisherName;
		this.publisherCompanyName = publisherCompanyName;
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
		this.patchVersion = patchVersion;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherCompanyName() {
		return publisherCompanyName;
	}

	public void setPublisherCompanyName(String publisherCompanyName) {
		this.publisherCompanyName = publisherCompanyName;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public int getPatchVersion() {
		return patchVersion;
	}

	public void setPatchVersion(int patchVersion) {
		this.patchVersion = patchVersion;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}


}
