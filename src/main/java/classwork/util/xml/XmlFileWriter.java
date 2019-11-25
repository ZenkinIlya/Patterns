package classwork.util.xml;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlFileWriter extends AbstractFileWriter {
	
	private Fallback fallback;
	
	public XmlFileWriter(Object mapper, String fileName, Fallback fallback) {
		super(mapper, fileName);
		this.fallback = fallback;
	}
	
	
	@Override
	public void writeFile() {
		XmlMapper o = (XmlMapper)mapper;
		
		System.out.println("Записываем данные файла в формате xml " + fileName);
		try {
			o.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), fallback);
			System.out.println("Данные записаны на диск в файл " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
