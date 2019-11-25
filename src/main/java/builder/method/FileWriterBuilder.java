package builder.method;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileWriter;
import factory.method.FileWriterFactory;

public class FileWriterBuilder {
	
	protected String fileName;
	protected Fallback fallback;
	protected String fileType;
	
	public FileWriterBuilder(String fileName, Fallback fallback, String fileType) {
		this.fileName = fileName;
		this.fallback = fallback;
		this.fileType = fileType;
	}
	
	public FileWriterBuilder() {
	}
	
	public FileWriterBuilder feelFileName(String fileName){
		this.fileName = fileName;
		return this;
	}
	
	public FileWriterBuilder feelFallBack(Fallback fallback){
		this.fallback = fallback;
		return this;
	}
	
	public FileWriterBuilder feelFileType(String fileType){
		this.fileType = fileType;
		return this;
	}
	
	public static FileWriterBuilder start(){
		return new FileWriterBuilder();
	}
	
	public AbstractFileWriter build(){
		FileWriterFactory writerFactory = FileWriterFactory.newFileWriterFactory(fileName, fallback);
		return writerFactory.fileWriter(fileType);
	}
	
}
