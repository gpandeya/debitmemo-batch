package com.mck.p2p.batchjob.debitmemo.debitmemobatch.validator;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemo;

public class DebitMemoValidator implements Validator<DebitMemo>{

	@Override
	public void validate(DebitMemo value) throws ValidationException {
		
		if(value.getSupplier()==null || ("").equalsIgnoreCase(value.getSupplier())){
			System.out.println("Supplier is empty or not valid at ID: "+value.getId());
		
			throw new ValidationException("Supplier name can not be empty, Empty value found for DebitMemo ID : "+value.getId());
		}
			
	}

}
