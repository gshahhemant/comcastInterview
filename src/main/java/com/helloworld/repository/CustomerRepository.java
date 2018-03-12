package com.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.helloworld.jpa.model.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
	
	@Query("select distinct cd from CustomerEntity cd left join fetch cd.transactionEntities td order by cd.customerId")
	public List<CustomerEntity> getAllCustombers();
	
	@Query("select cd from CustomerEntity cd left join fetch cd.transactionEntities td  where cd.customerId=:customerId")
	public CustomerEntity getCustomberById(@Param("customerId") int customerId);
	
}
