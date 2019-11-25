package classwork.params.da;

import classwork.params.entity.template.Fallback;

import java.io.*;

public class JsonParameterSerializeReader {
	
	public Fallback customSerializeReader(String filename) throws IOException, ClassNotFoundException {
		try (FileInputStream fos = new FileInputStream(filename)){
			try (ObjectInputStream oos = new ObjectInputStream(fos)){
				return (Fallback)oos.readObject();
			}
		}
		
	}
	
}
