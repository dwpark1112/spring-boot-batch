package sample.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.batch.item.ItemProcessor;

import sample.batch.model.TestResult;

public class Processor implements ItemProcessor<String, TestResult>{

	private String[] names = { "Roo", "Alpha", "Beta?" };

	@Override
	public TestResult process(String s) throws Exception {
		TestResult result = new TestResult();
		result.setMessage(s);
		result.setRandomName(names[new Random().nextInt(names.length)]);
		result.setDateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		return result;
	}
}
