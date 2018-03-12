package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.TransactionEntity;
import com.helloworld.model.Transaction;

@Service
public class TransactionEntityTranslator  extends AbstractModelTranslator<Transaction, TransactionEntity>  {

	@Override
	public TransactionEntity translate(Transaction original) {

		TransactionEntity transactionEntity = null;
		if (original != null) {
			transactionEntity = new TransactionEntity(original.getTransactionName(),original.getAmount());
		}
		return transactionEntity;
	}
}
