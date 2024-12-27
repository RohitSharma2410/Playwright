package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

	public Properties getprop() {
		return properties;
	}

	public PropertiesHelper(String path) {
		getProperties(path);
	}

	public Properties properties = null;

	public void getProperties(String path) {

		try {

			properties = new Properties();

			properties.load(new FileInputStream(System.getProperty("user.dir").concat(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
