package XYZBank;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CustomerLoginPage;
import pageObjects.HomePage;

public class CustomerLoginValidationTest extends BaseTest {
	
	public static HomePage homePage;
	public static CustomerLoginPage customerLoginPage;
	
	String username = prop.getProperty("userName");
	
	@Parameters({"browser"})
	@BeforeMethod
	public void launcher(String browser) throws InterruptedException {
		
		initialization(browser);
		
		homePage = new HomePage(driver);
		customerLoginPage = new CustomerLoginPage(driver);
	}

	@Test(description = "Verify Login Functionality Of Customer")
	public void customerLoginValidation() throws InterruptedException {
		
		homePage.waitTillPageLoaded(driver);
		homePage.clickCustomerLogin();
		Thread.sleep(1000);
		
		customerLoginPage.selectUserName(username);
		customerLoginPage.clickLogin();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText(), username, 
				"Verify Redirection To Welcome Page ");
	}

}
