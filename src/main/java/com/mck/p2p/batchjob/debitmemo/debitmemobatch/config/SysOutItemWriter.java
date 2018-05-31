package com.mck.p2p.batchjob.debitmemo.debitmemobatch.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemo;

public class SysOutItemWriter implements ItemWriter<DebitMemo>{


	@Override
	public void write(List<? extends DebitMemo> items) throws Exception {
		System.out.println("Size of the chunk was : "+items.size());
		
		for(DebitMemo item :items){
			System.out.println( " >> "+item.toString());
		}
		
	}

}
