package com.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helloworld.jpa.model.CustomberEntity;

public interface CustomberRepository extends CrudRepository<CustomberEntity, Integer> {
	
	@Query("select distinct cd from CustomberEntity cd left join fetch cd.transactionEntities td order by cd.customberId")
	public List<CustomberEntity> getAllCustombers();
	
	@Query("select cd from CustomberEntity cd left join fetch cd.transactionEntities td  where cd.customberId=:customberId")
	public CustomberEntity getCustomberById(@Param("customberId") int customberId);
	
}
