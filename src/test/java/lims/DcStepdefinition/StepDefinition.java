package lims.DcStepdefinition;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefinition {
	WebDriver driver;

	@Given("user is on the lims login page")
	public void user_is_on_the_lims_login_page() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://130.78.62.52:107/#/Login?IPADDRESS=192.168.1.100&MACHINE=DHHCLBX5PFB3");

	    
	}

	@When("user enter valid {string}and{string}")
	public void user_enter_valid_and(String string, String string2) throws InterruptedException {
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		txtUsername.sendKeys("VM");
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	txtPassword.sendKeys("Pas123");
	}


	
	

	@When("user click the login button")
	public void user_click_the_login_button() {
	
	
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();

	}

	@When("user click the menu")
	public void user_click_the_menu() throws InterruptedException {
		Thread.sleep(30000);
		String homePage = driver.getCurrentUrl();
		assertTrue("Checking whether user on home page",homePage.contains("Mainpage"));
			
		
		WebElement btnMenu = driver.findElement(By.xpath("//i[text()='menu']"));
		btnMenu.click();
	   
	}

	@When("user click the order entry")
	public void user_click_the_order_entry() throws InterruptedException {
		Thread.sleep(5000);
		WebElement menuOrderManagement = driver.findElement(By.xpath("//div[text()=' Order management ']"));
		menuOrderManagement.click();
		Thread.sleep(5000);
		WebElement menuOrderentry = driver.findElement(By.xpath("//div[text()=' Order entry ']//parent::mat-toolbar-row"));
		menuOrderentry.click();
	   
	}

	@When("user enter valid {string},{string}")
	public void user_enter_valid(String Givenname, String Familyname) throws InterruptedException {

		Thread.sleep(15000);
		WebElement txtGivenname = driver.findElement(By.id("Givenname"));
		txtGivenname.sendKeys("patient");
		WebElement txtFamilyname = driver.findElement(By.id("Familyname"));
		txtFamilyname.sendKeys("search");
	   
	}

	@When("user click the search button")
	public void user_click_the_search_button() throws InterruptedException {
		Thread.sleep(5000);
		WebElement btnSearch = driver.findElement(By.xpath("//span[text()=' SEARCH ']"));
		btnSearch.click();
	    
	}
	@When("user click the New order button")
	public void user_click_the_New_order_button() throws InterruptedException {
		Thread.sleep(10000);
		WebElement btnPatient = driver.findElement(By.xpath("//span[text()='Patient']"));
		btnPatient.click();
		Thread.sleep(5000);
		WebElement btnNewOrder = driver.findElement(By.xpath("//span[text()=' NEW ORDER ']"));
		btnNewOrder.click();
	}
	@When("user click patient catagory")
	public void user_click_patient_catagory() throws InterruptedException, AWTException {
		Thread.sleep(24000);
		WebElement btnPatientCatagory = driver.findElement(By.xpath("(//span[text()='* Patient category'])[1]"));
		btnPatientCatagory.click();
		WebElement btnNHSPatient = driver.findElement(By.xpath("//span[text()=' NHS Patient ']"));
		btnNHSPatient.click();
		WebElement btnClinician = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		btnClinician.click();
		btnClinician.sendKeys("Bob v");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement btnRequestingLocation = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		btnRequestingLocation.click();
		btnRequestingLocation.sendKeys("b");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement txtOrderSearch = driver.findElement(By.id("txtfavSearch"));
		txtOrderSearch.sendKeys("vmdct");
		WebElement btnTestDct = driver.findElement(By.xpath("//div[text()=' (VMDCT) ']"));
		btnTestDct.click();
		Thread.sleep(10000);
		WebElement btnSpecimen = driver.findElement(By.xpath("//span[text()=' SPECIMEN ']"));
		btnSpecimen.click();
	}
	@When("user click the result")
	public void user_click_the_result() throws InterruptedException {
		Thread.sleep(15000);
//		WebElement btnCollectionDate = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
//		btnCollectionDate.click();
		WebElement btnCollectionDate = driver.findElement(By.xpath("//input[@id='pastefocusID']"));
		btnCollectionDate.click();
		btnCollectionDate.sendKeys("30");
//		WebElement btnCollectionDate3 = driver.findElement(By.xpath("//div[text()=' 30 ']"));
//		btnCollectionDate3.click();
		WebElement btnSpecimenSpace = driver.findElement(By.xpath("(//div[@class='row'])[9]"));
		btnSpecimenSpace.click();
		WebElement btnResult = driver.findElement(By.xpath("//span[text()=' RESULT ']"));
		btnResult.click();
	}
	@When("user enter the result")
	public void user_enter_the_result() throws InterruptedException, AWTException {
		Thread.sleep(25000);
		WebElement txtTestResult = driver.findElement(By.xpath("//input[@type='text']"));
		txtTestResult.sendKeys("55");
		Thread.sleep(50000);
//		WebElement btnResultSpace = driver.findElement(By.xpath("//div[@class='resultspace']"));
//		btnResultSpace.click();
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(15000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement btnSave = driver.findElement(By.xpath("(//span[text()=' SAVE '])[1]"));
		js.executeScript("arguments[0].click()",btnSave);
		
		Thread.sleep(15000);
		WebElement btnAuthorize = driver.findElement(By.xpath("(//span[text()=' AUTHORISE '])[1]"));
		js.executeScript("arguments[0].click()",btnAuthorize);
		Thread.sleep(15000);
		WebElement btnCancel3 = driver.findElement(By.xpath("(//span[text()=' CANCEL '])[1]"));
		btnCancel3.click();
	}
	@When("user enter the {string},{string}")
	public void user_enter_the(String string, String string2) throws InterruptedException {
		Thread.sleep(20000);
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		txtUsername.sendKeys("VM");
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	txtPassword.sendKeys("Pas123");
	    
	}
	@When("user click the Search button")
	public void user_click_the_Search_button() throws InterruptedException {
		Thread.sleep(5000);
		WebElement btnSearch = driver.findElement(By.xpath("//span[text()=' SEARCH ']"));
		btnSearch.click();
	}

	@When("User click the new order button")
	public void user_click_the_new_order_button() throws InterruptedException {
		Thread.sleep(10000);
		WebElement btnPatient = driver.findElement(By.xpath("//span[text()='Patient']"));
		btnPatient.click();
		Thread.sleep(5000);
		WebElement btnNewOrder = driver.findElement(By.xpath("//span[text()=' NEW ORDER ']"));
		btnNewOrder.click();
	}

	@When("user click Patient Catagory")
	public void user_click_Patient_Catagory() throws InterruptedException, AWTException {
		Thread.sleep(24000);
		WebElement btnPatientCatagory = driver.findElement(By.xpath("(//span[text()='* Patient category'])[1]"));
		btnPatientCatagory.click();
		WebElement btnNHSPatient = driver.findElement(By.xpath("//span[text()=' NHS Patient ']"));
		btnNHSPatient.click();
		WebElement btnClinician = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		btnClinician.click();
		btnClinician.sendKeys("Bob v");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement btnRequestingLocation = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		btnRequestingLocation.click();
		btnRequestingLocation.sendKeys("b");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement txtOrderSearch = driver.findElement(By.id("txtfavSearch"));
		txtOrderSearch.sendKeys("vmdct");
		WebElement btnTestDct = driver.findElement(By.xpath("//div[text()=' (VMDCT) ']"));
		btnTestDct.click();
		Thread.sleep(10000);
		WebElement btnSpecimen = driver.findElement(By.xpath("//span[text()=' SPECIMEN ']"));
		btnSpecimen.click();
	}

	@When("user click the Result")
	public void user_click_the_Result() throws InterruptedException {
		Thread.sleep(15000);
		WebElement btnCollectionDate = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		btnCollectionDate.click();
//		WebElement btnCollectionDate = driver.findElement(By.xpath("//input[@id='pastefocusID']"));
//		btnCollectionDate.click();
//		btnCollectionDate.sendKeys("30");
		WebElement btnCollectionDate3 = driver.findElement(By.xpath("//div[text()=' 30 ']"));
		btnCollectionDate3.click();
//		WebElement btnSpecimenSpace = driver.findElement(By.xpath("(//div[@class='row'])[9]"));
//		btnSpecimenSpace.click();
		WebElement btnResult = driver.findElement(By.xpath("//span[text()=' RESULT ']"));
		btnResult.click();
	}

	@When("user enter the Result")
	public void user_enter_the_Result() throws InterruptedException, AWTException {
		Thread.sleep(25000);
		WebElement txtTestResult = driver.findElement(By.xpath("//input[@type='text']"));
		txtTestResult.sendKeys("55");
		Thread.sleep(50000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyRelease(KeyEvent.VK_TAB);
		
		
		
		
	   
	}
}
