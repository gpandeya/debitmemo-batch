package com.mck.p2p.batchjob.debitmemo.debitmemobatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.JobFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	
	@Bean
	public Step step1(){
		return stepFactory.get("step1").tasklet(new Tasklet(){
				@Override
				public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
					System.out.println("Hello World from Debit Memo batch JOB!");
					return RepeatStatus.FINISHED;
				}
			}).build();
	
	}
	
	@Bean
	public Job debitMemoBatchJob(){
		return jobFactory.get("debit-memo-batch").start(step1()).build();
	}
	
}
