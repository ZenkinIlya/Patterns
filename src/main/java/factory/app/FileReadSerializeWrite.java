package factory.app;

import classwork.params.da.JsonParameterReader;
import classwork.params.da.JsonParameterSerializeWriter;
import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import classwork.util.AbstractFileWriter;
import classwork.util.FilesComparator;
import factory.method.FileReaderFactory;
import factory.method.FileWriterFactory;

import java.io.IOException;

/**
 * @author Evgeni Korolev
 * @date 03.04.2018
 */
public class FileReadSerializeWrite {
	
	
	public static final String TEMP_V_1_OUT = "temp.v1.out";
	private static final String PARAMETERS = "parameters.v1.";
	private static final String RESULT_PARAMETERS_JSON = "result_parameters_from_json.v1.";
	private static final String RESULT_PARAMETERS_XML = "result_parameters_from_xml.v1.";

	/**
     * Из файла parameters.json считываем данные
     * После сериазилуем в файл temp.out
     * Далее перегоняем потоком в result_parameters.json
     *
     * Смысл задания - сериализовать объект в файл.
     * Из файла считать - записать в новый файл и сравнить с исходным
     *
	 * fileReader->serializeWriter
	 * parameters.v1.json -> temp.v1.out
	 *
	 *
	 * считали с помощью маппера файл json
	 * записали его с помощью сериализации в файл TEMP_V_1_OUT
     * */
	
	//todo нужно реализовать паттерн фабричный метод для считывания из файлов разного формата
    public static void main(String... args) throws IOException {
        
        String fileName = "parameters.v1.json";

	    JsonParameterReader service = new JsonParameterReader();
        Fallback business = null;
	    System.out.println("Значение business: " + business);
	    System.out.println("Считываем данные из файла " + fileName);
        business = service.read(fileName);
	    System.out.println("Данные считаны:");
	    System.out.println(business);

        JsonParameterSerializeWriter mySerializer = new JsonParameterSerializeWriter();
	    System.out.println("Записываем данные в файла " + TEMP_V_1_OUT);
        mySerializer.customSerializeWriter(business, TEMP_V_1_OUT);  //сериализация
	    System.out.println("Данные записаны на диск в файл " + TEMP_V_1_OUT);


	    //считывание исходных файлов xml и json в объект fallback с помощью маппера
		FileReaderFactory readerFactory = FileReaderFactory.newFileReaderFactory(PARAMETERS);
		AbstractFileReader fileJsonReader = readerFactory.fileReader("json");
		Fallback businessJson = (Fallback) fileJsonReader.readFile();

		AbstractFileReader fileXmlReader = readerFactory.fileReader("xml");
		Fallback businessXml = (Fallback) fileXmlReader.readFile();

		//запись считанных объектов файла xml и json в файлы xml и json с помощью маппера
		FileWriterFactory writerFactoryJSON = FileWriterFactory.newFileWriterFactory(RESULT_PARAMETERS_JSON, businessJson);
		AbstractFileWriter fileJsonWriterFromJSON = writerFactoryJSON.fileWriter("json");
		fileJsonWriterFromJSON.writeFile();

		AbstractFileWriter fileXmlWriterFromJSON = writerFactoryJSON.fileWriter("xml");
		fileXmlWriterFromJSON.writeFile();

		FileWriterFactory writerFactoryXML = FileWriterFactory.newFileWriterFactory(RESULT_PARAMETERS_XML, businessXml);
		AbstractFileWriter fileJsonWriterFromXML = writerFactoryXML.fileWriter("json");
		fileJsonWriterFromXML.writeFile();

		AbstractFileWriter fileXmlWriterFromXML = writerFactoryXML.fileWriter("xml");
		fileXmlWriterFromXML.writeFile();

		System.out.println(FilesComparator.CompareFiles(PARAMETERS + "json", RESULT_PARAMETERS_JSON + "json"));
		System.out.println(FilesComparator.CompareFiles(PARAMETERS + "json", RESULT_PARAMETERS_XML + "json"));
		System.out.println(FilesComparator.CompareFiles(PARAMETERS + "xml", RESULT_PARAMETERS_JSON + "xml"));
		System.out.println(FilesComparator.CompareFiles(PARAMETERS + "xml", RESULT_PARAMETERS_XML + "xml"));
    }
}
