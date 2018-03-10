package com.helloworld.translator;

import org.springframework.stereotype.Service;

import com.helloworld.jpa.model.CustomberEntity;
import com.helloworld.model.Customber;
import com.helloworld.model.Transaction;

@Service
public class CustomberTranslator  extends AbstractModelTranslator<CustomberEntity, Customber>  {

	@Override
	public Customber translate(CustomberEntity original) {
		if (original != null) {
			Customber customber = new Customber(original.getCustomberId(),original.getFirstName(),original.getLastName(),original.getAddress(),original.getPhoneNumber());

			original.getTransactions().forEach(transactionEntity -> {
				Transaction  transaction = new Transaction(transactionEntity.getTransactionId(),transactionEntity.getTransactionName(),transactionEntity.getAmount());
				customber.getTransactions().add(transaction);
			});

			return customber;
		}
		return null;
	}
}
