package com.mck.p2p.batchjob.debitmemo.debitmemobatch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemo;

public class UpperCaseSupplierProcessor implements ItemProcessor <DebitMemo, DebitMemo>{

	@Override
	public DebitMemo process(DebitMemo item) throws Exception {
		return new DebitMemo(
				item.getId(),
				item.getDescription(),
				item.getSupplier().toUpperCase()
				);
		
	}

}
