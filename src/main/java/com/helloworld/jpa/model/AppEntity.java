package com.helloworld.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Hemant Shah
 */

@Entity
@Table(name = "app_detail")
public class AppEntity implements Serializable {
    
	private static final long serialVersionUID = -4450513721784577290L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "app_id")
	private int appId;
	@Column(name = "name")
	private String name;
	@Column(name = "publisher_name")
	private String publisherName;
	@Column(name = "company_name")
	private String publisherCompanyName;
    @Column(name = "major_version")
	private int majorVersion;
	@Column(name = "minor_version")
	private int minorVersion;
	@Column(name = "patch_version")
	private int patchVersion;
	@Column(name = "short_description")
	private String shortDescription;
	@Column(name = "long_description")
	private String longDescription;
	
	
	public AppEntity() {
		
	}
		
	public AppEntity(int appId, String name, String publisherName, String publisherCompanyName, int majorVersion,
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
		
	public AppEntity(String name, String publisherName, String publisherCompanyName, int majorVersion,
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
