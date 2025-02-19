package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromProperties(String Key) throws IOException {
		FileInputStream pfis=new FileInputStream("C:\\Users\\sheeb\\OneDrive\\Desktop\\Advance Selenium\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String data = prop.getProperty(Key);
		return data;
		
	}

}
