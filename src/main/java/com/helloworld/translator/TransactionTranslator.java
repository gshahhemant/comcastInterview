package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.TransactionEntity;
import com.helloworld.model.Transaction;

@Service
public class TransactionTranslator  extends AbstractModelTranslator<TransactionEntity, Transaction>  {

	@Override
	public Transaction translate(TransactionEntity original) {

		Transaction  transaction = null;
		if (original != null) {
			transaction = new Transaction(original.getTransactionId(),original.getTransactionName(),original.getAmount());
		}
		return transaction; 
	}
	
	public void translateUpdate(Transaction  transaction , TransactionEntity transactionEntity) {

		if (transaction != null) {
			transactionEntity.setAmount(transaction.getAmount());
			transactionEntity.setTransactionName(transaction.getTransactionName());
		}
	}
}
