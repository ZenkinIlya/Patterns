package classwork.util.xml;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlFileReader extends AbstractFileReader {

	public XmlFileReader(Object mapper, String fileName) {
		super(mapper, fileName);
	}

	private Fallback fallback;

	@Override
	public Object readFile() {
		XmlMapper o = (XmlMapper)mapper;

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
