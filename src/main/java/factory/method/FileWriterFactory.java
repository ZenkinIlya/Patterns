package factory.method;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileWriter;
import classwork.util.json.JsonFileWriter;
import classwork.util.xml.XmlFileWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

public class FileWriterFactory {
	
	protected String fileName;
	protected Fallback fallback;
	
	private FileWriterFactory(String fileName, Fallback fallback) {
		this.fileName = fileName;
		this.fallback = fallback;
	}
	
	public AbstractFileWriter fileWriter(String typeFile){
		switch (typeFile){
			case "json":
				return new JsonFileWriter(new ObjectMapper(), fileName + typeFile, fallback);
			default:
				return new XmlFileWriter(new XmlMapper(), fileName + typeFile, fallback);
		}
	}
	
	public static final FileWriterFactory newFileWriterFactory(String fileName, Fallback fallback){
		return new FileWriterFactory(fileName, fallback);
	}
	
}
