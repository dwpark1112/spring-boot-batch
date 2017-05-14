/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import sample.batch.model.TestResult;

@SpringBootApplication
@EnableBatchProcessing
public class SampleBatchApplication {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public Job processJob(){
		return jobs.get("processJob")
			.listener(listener())
			.flow(printMessageStep())
			.end()
			.build();
	}

	@Bean
	public Step printMessageStep(){
		return steps.get("printMessasgeStep")
			.<String, TestResult> chunk(10)
			.reader(new Reader())
			.processor(new Processor())
			.writer(writer())
			.build();
	}

	@Bean
	public FlatFileItemWriter<TestResult> writer() {
		FlatFileItemWriter<TestResult> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("csv/student.csv"));
		writer.setLineAggregator(new DelimitedLineAggregator<TestResult>() {{
			setDelimiter("\t");
			setFieldExtractor(new BeanWrapperFieldExtractor<TestResult>() {{
				setNames(new String[] {"message", "dateTime", "randomName"});
			}});
		}});
		return writer;
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompleteListener();
	}

	public static void main(String[] args) throws Exception {
		// System.exit is common for Batch applications since the exit code can be used to
		// drive a workflow
		System.exit(SpringApplication
				.exit(SpringApplication.run(SampleBatchApplication.class, args)));
	}

}
