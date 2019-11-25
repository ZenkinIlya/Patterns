package classwork.params.da;

import classwork.params.entity.template.Fallback;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JsonParameterSerializeWriter {
	
	public void customSerializeWriter(Fallback parameters, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName)){
			try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
				oos.writeObject(parameters);
			}
		}
	}
	
}
