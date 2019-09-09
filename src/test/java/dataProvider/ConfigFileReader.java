package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	
	public String getUrl() throws IOException {
		String path=System.getProperty("user.dir");
		properties=new Properties();
		properties.load(new FileInputStream(path+"\\configs\\configuration.properties"));
		return properties.getProperty("url");
	}
}
