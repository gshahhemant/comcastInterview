package com.helloworld.repository;

import org.springframework.data.repository.CrudRepository;

import com.helloworld.jpa.model.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long>  {

}
