package classwork.util.json;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileReader extends AbstractFileReader {
	
	public JsonFileReader(ObjectMapper mapper, String fileName) {
		super(mapper, fileName);
	}

	private Fallback fallback;
	@Override
	public Object readFile() {
		ObjectMapper o = (ObjectMapper)mapper;

		System.out.println("Считываем данные из файла " + fileName);
		try {
			fallback = o.readValue(new File(fileName), Fallback.class);
			System.out.println("Данные считаны на диск в файл " + fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fallback;
	}
}
