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
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemo;
import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemoFieldSetMapper;

@Configuration

public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	/*
	 * 05.31.2018 : replace with CSVFileItemReader
	 * @Bean
	public FlatFileItemReader<DebitMemo> debitMemoItemReader(){
		
		//String filePath = "\\data\\debitmemo.csv"; 
		//String filePath=" file://debitmemo.csv";
		FlatFileItemReader<DebitMemo> reader = new FlatFileItemReader<DebitMemo>();
		reader.setLinesToSkip(1);
		
		//reader.setResource(new FileSystemResource(filePath));
		reader.setResource(new ClassPathResource("../data/debitmemo.csv", JobConfiguration.class));
		
		DefaultLineMapper<DebitMemo> lineMapper = new DefaultLineMapper<DebitMemo>();
		
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames(new String [] {"id","description","supplier"});
		
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(new DebitMemoFieldSetMapper());
		lineMapper.afterPropertiesSet();
		
		reader.setLineMapper(lineMapper);
		
		return reader;
	}*/
	
	/*@Bean
	 * 05.31.2018 : replaced with SysoutItemWriter
	public ItemWriter<DebitMemo> debitMemoitemWriter(){
		ItemWriter<DebitMemo> itemWriter=null;
		for(DebitMemo debitMemo : itemWriter){
			
		}
		
		return items ->{
			for(DebitMemo debitMemo : items)
				System.out.println(debitMemo.toString());
		};
	}*/
	
	@Bean
	public FlatFileItemReader<DebitMemo> itemReader(){
		return new CSVFileItemReader().itemReader();
	}
	
	@Bean
	public SysOutItemWriter itemWriter(){
		return new SysOutItemWriter();
	}
	
	@Bean
	public Step step1(){
		return stepFactory.get("step1")
				.<DebitMemo,DebitMemo>chunk(10)
				.reader(itemReader())
				.writer(itemWriter()).build();
			
	}
	
	@Bean
	public Job debitMemoBatchJob(){
		return jobFactory.get("debit-memo-batch").start(step1()).build();
	}
	
	/* 
	 * This is initial commit, it prints hardcoded string on console: Hello World from Debit Memo batch JOB!
	 * 
	 * @Bean
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
	}*/
	
}
