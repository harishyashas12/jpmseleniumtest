package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ReadProperyFile {

	static Logger logger = Logger.getLogger("ReadProperyFile");

	/* -----Below code use to read property file-----*/	
	public static String getConfigData(String strConfigKey){	
		String mentionKey = null;
		try {
			String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\environmentprops\\config.properties";
			File file = new File(filepath);
			FileInputStream fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			mentionKey = prop.getProperty(strConfigKey);
		} catch (Exception e) 
		{
			logger.debug("Exception encountered while reading the file" +e.getMessage());
			e.printStackTrace();
		}
		return mentionKey;
	}
}
