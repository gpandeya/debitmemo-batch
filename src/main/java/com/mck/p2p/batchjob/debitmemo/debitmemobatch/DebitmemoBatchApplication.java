package com.mck.p2p.batchjob.debitmemo.debitmemobatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class DebitmemoBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebitmemoBatchApplication.class, args);
	}
}
