package sample.batch;

import org.springframework.batch.item.ItemReader;

public class Reader implements ItemReader<String>{

	private String[] messages = {"Hello",
		"World",
		"Happy"};

	private int count = 0;

	@Override
	public String read() throws Exception {
		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}
}
