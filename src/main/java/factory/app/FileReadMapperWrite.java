package factory.app;

import classwork.params.da.JsonParameterSerializeReader;
import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileWriter;
import factory.method.FileWriterFactory;
import java.io.IOException;


/**
 * читаем из temp.out
 *
 * serializeReader -> objectMapper
 * temp.v1.out -> result_parameters.v1.json
 *
 * считали с помощбю сериализации файл temp.v1.out
 * записали его с помощью маппера в json и xml формат
 * */
public class FileReadMapperWrite {
	
	public static final String RESULT_PARAMETERS = "result_parameters.v1.";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String fileName = "temp.v1.out";
		
		Fallback business = null;
		System.out.println("Значение business: " + business);
		JsonParameterSerializeReader myReader = new JsonParameterSerializeReader();
		System.out.println("Считываем данные из файла " + fileName);
		business = myReader.customSerializeReader(fileName);
		System.out.println("Данные считаны с диска из файл " + fileName);
		System.out.println("Значение business: " + business);

		//запись сериализованного файла - temp.v1.out в файлы формата json и xml с помощью маппера
		FileWriterFactory writerFactory = FileWriterFactory.newFileWriterFactory(RESULT_PARAMETERS, business);
		AbstractFileWriter fileJsonWriter = writerFactory.fileWriter("json");
		fileJsonWriter.writeFile();
		
		AbstractFileWriter fileXmlWriter = writerFactory.fileWriter("xml");
		fileXmlWriter.writeFile();
		
	}
	
}
