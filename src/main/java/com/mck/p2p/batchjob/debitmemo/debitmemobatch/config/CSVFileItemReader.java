package com.mck.p2p.batchjob.debitmemo.debitmemobatch.config;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemo;
import com.mck.p2p.batchjob.debitmemo.debitmemobatch.domain.DebitMemoFieldSetMapper;

public class CSVFileItemReader {

	
	private FlatFileItemReader<DebitMemo> reader;
	
	public CSVFileItemReader(){
		
		//String filePath = "\\data\\debitmemo.csv"; 
				//String filePath=" file://debitmemo.csv";
				reader = new FlatFileItemReader<DebitMemo>();
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
		
	}
	
	public FlatFileItemReader<DebitMemo> itemReader(){
		return reader;
	}
	
}
