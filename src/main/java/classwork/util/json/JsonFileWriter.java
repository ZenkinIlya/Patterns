package classwork.util.json;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileWriter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileWriter extends AbstractFileWriter {
	
	private Fallback fallback;
	
	public JsonFileWriter(Object mapper, String fileName, Fallback fallback) {
		super(mapper, fileName);
		this.fallback = fallback;
	}
	
	@Override
	public void writeFile() {
		
		ObjectMapper o = (ObjectMapper)mapper;
		
		System.out.println("Записываем данные файла в формате json " + fileName);
		try {
			o.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), fallback);
			System.out.println("Данные записаны на диск в файл " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
