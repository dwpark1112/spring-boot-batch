package sample.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {
	@Override
	public void write(List<? extends String> list) throws Exception {
		for (String msg: list){
			System.out.println( "Write this: " + msg);
		}
	}
}
