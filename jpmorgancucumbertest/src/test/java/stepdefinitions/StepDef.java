package stepdefinitions;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.GooglePageObj;
import org.apache.log4j.Logger;

public class StepDef {
	
	GooglePageObj googlePage = new GooglePageObj();
	Logger logger = Logger.getLogger("StepDef");

	@Given("^User navigate to google homepage \"([^\"]*)\"$")	
	public void UserNavigatetoGoogleHomePage(String strWebsiteName) throws Exception {
		googlePage.launchURL();
		String actualTitle = googlePage.verifyHomepage();
		Assert.assertTrue(actualTitle.equals(strWebsiteName));
		logger.info("Successfully navigated to google page");
	}
	
	@When("^User searches using given data \"([^\"]*)\" and select search result on googlepage$")	
	public void userSearchorCompanyNameUsingandSelectSearchResultOnGooglePage(String strcompanyname) throws Exception {
		googlePage.provideSearchInput(strcompanyname);
		googlePage.clickOnLink();
		logger.info("Clicked on search result link successfully");
	}
	
	@Then("^User verify JP Mogan logo displayed on home page successfully$")
	public void userJPMoganLogoDisplayeonHomePageSuccessfully() throws Exception {
		boolean isLogoDisplayed = googlePage.verifyLogo();
		Assert.assertTrue(isLogoDisplayed);
		logger.info("JP Mogan logo displayed successfully");
	}
	
}
