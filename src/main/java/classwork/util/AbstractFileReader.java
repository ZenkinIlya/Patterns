package classwork.util;

public abstract class AbstractFileReader {
	
	protected Object mapper;
	protected String fileName;
	
	public AbstractFileReader(Object mapper, String fileName) {
		this.mapper = mapper;
		this.fileName = fileName;
	}
	
	public abstract Object readFile();
}
