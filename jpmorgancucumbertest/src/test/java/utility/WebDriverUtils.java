package utility;
import org.apache.log4j.Logger;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utility.ReadProperyFile;

public class WebDriverUtils {

	public static WebDriver driver;
	public static String browserName = ReadProperyFile.getConfigData("browser");
	public static String chromedriverpath = ReadProperyFile.getConfigData("chromebrowserpath");
	public static String iEDriverPath = ReadProperyFile.getConfigData("iEDriver");
	static Logger logger = Logger.getLogger("WebDriverUtils");

	/******This method is to create driver for given browser in config file*****/	
	public static WebDriver driverSetup() 	{

		try {
			switch (browserName) 
			{
			case "IE":
				logger.info("Creating driver for IE browser");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + iEDriverPath);
				driver = new InternetExplorerDriver(); 
				break;
			case "chrome":
				logger.info("Creating driver for chrome browser");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromedriverpath);
				driver = new ChromeDriver();
				break;
			default:
				logger.info("No browser is defined in config file, creating driver for chrome browser by Default");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromedriverpath);
				driver = new ChromeDriver();
				break;

			}
		} catch (Exception e) 
		{
			logger.debug("Exception captured:" + e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}	


	/*******Below code is use to check Element visibility in screen it returns true if displayed or false if not displayed*****/		
	public static boolean isWebElementVisible(WebElement element) 
	{
		boolean isElementDisplayed = false;
		try 
		{
			isElementDisplayed = element.isDisplayed();			    
		} catch (NoSuchElementException e) 
		{
			logger.debug("Element is not visible");
		}
		return isElementDisplayed;
	}
}
