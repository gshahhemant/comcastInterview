package com.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helloworld.jpa.model.AppEntity;


/**
 * @author Hemant Shah
 */
public interface AppDetailRepository extends CrudRepository<AppEntity, Integer>  {


	@Query("select  ad from AppEntity ad where ad.appId=:appId")
	public AppEntity getAppById(@Param("appId") int appId);

	@Query("select ad from AppEntity ad order by ad.appId")
	public List<AppEntity> getAllApps();

}
