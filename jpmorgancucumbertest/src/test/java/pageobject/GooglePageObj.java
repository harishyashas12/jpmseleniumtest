package pageobject;


import org.apache.log4j.Logger;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ReadProperyFile;
import utility.WebDriverUtils;

public class GooglePageObj {

	public WebDriver driver;
	Logger logger = Logger.getLogger("GooglePageObj");

	public GooglePageObj() 
	{
		driver = WebDriverUtils.driverSetup();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//a[@href='https://www.jpmorgan.com/']")
	private WebElement jpMorganLinkClick;

	@FindBy(xpath = "//div[@class='logo-desktop-only']//div[@class='logo container-fluid']")
	private WebElement jpMorganLogo;
	By verifyImage = By.xpath("//div[@class='logo-desktop-only']//div[@class='logo container-fluid']");

	/*-----Below code for launch google web page-----*/	
	public void launchURL() {
		String url = ReadProperyFile.getConfigData("googleURL");	
		driver.get(url);
		driver.manage().window().maximize();
		int wait = Integer.parseInt(ReadProperyFile.getConfigData("implicitwait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		int pageloadTime = Integer.parseInt(ReadProperyFile.getConfigData("pageloadTimeout"));
		driver.manage().timeouts().pageLoadTimeout(pageloadTime, TimeUnit.SECONDS);
		logger.info("Successfully Launched the browser");
	}

	/*-----Below code for retrieve page title-----*/
	public String verifyHomepage() {
		logger.info("Verifying page title");
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	/*-----Below code for put data on search-box-----*/	
	public void provideSearchInput(String strSearchData) {
		searchTextBox.sendKeys(strSearchData);
		searchTextBox.sendKeys(Keys.ENTER);
		logger.info("Search data entered successfully");
	}

	/*-----Below code for click on jpmorgan link-----*/	
	public void clickOnLink() {
		jpMorganLinkClick.click();
		WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt(ReadProperyFile.getConfigData("pageloadTimeout")));
		wait.until(ExpectedConditions.presenceOfElementLocated(verifyImage));
	}

	/*-----Below code for validate jpmorgan logo -----*/	
	public boolean verifyLogo() {
		logger.info("Verifying JPM logo");
		return WebDriverUtils.isWebElementVisible(jpMorganLogo);
	}	
}
