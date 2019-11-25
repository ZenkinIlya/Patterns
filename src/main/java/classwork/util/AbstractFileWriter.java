package classwork.util;

public abstract class AbstractFileWriter {
	
	protected Object mapper;
	protected String fileName;
	
	public AbstractFileWriter(Object mapper, String fileName) {
		this.mapper = mapper;
		this.fileName = fileName;
	}
	
	public abstract void writeFile();
}
