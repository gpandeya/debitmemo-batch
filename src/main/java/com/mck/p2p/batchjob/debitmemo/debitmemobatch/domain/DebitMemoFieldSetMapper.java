package com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class DebitMemoFieldSetMapper implements FieldSetMapper<DebitMemo>{

	@Override
	public DebitMemo mapFieldSet(FieldSet fieldSet) throws BindException {
		
		return new DebitMemo(fieldSet.readString("id"),
				fieldSet.readString("description"),
				fieldSet.readString("supplier"));
	}

}
