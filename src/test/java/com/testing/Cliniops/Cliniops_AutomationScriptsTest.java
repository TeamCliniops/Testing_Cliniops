package com.testing.Cliniops;


import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

static WebDriver dr;
Method tc ;
	@BeforeMethod
	@Parameters("browser")
	public static void Selectbrowser(String browser) throws Exception{
		
		
			
		if(browser.equalsIgnoreCase("firefox")){
			//System.setProperty("webdriver.firefox.marionette", "C:/Users/Zunaira's/Documents/QA automation/geckodriver-v0.16.1-win64/geckodriver.exe");
			//Ignore--This is added to check in github
			dr=new FirefoxDriver();	
			dr.manage().window().maximize();
System.out.println("firefox launched");
		}
		else if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:/Users/Zunaira's/Documents/QA automation/chromedriver.exe");
			dr=new ChromeDriver();
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("IE")){
			//System.setProperty("webdriver.ie.driver", "C:/Users/Zunaira's/Documents/QA automation/IEDriverServer.exe");
	        dr=new InternetExplorerDriver();
	        
	        dr.manage().window().maximize();
	        Capabilities capabilities = DesiredCapabilities.internetExplorer();
	        ((DesiredCapabilities) capabilities).setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        ((DesiredCapabilities) capabilities).setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	        ((DesiredCapabilities) capabilities).setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

	        ((DesiredCapabilities) capabilities).setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		}
					
		
	}
	
	@Test(priority=1)
	public void loginErrorMessage1() throws IOException, InterruptedException{
		System.out.println("Login:Testcase1 started");
		dr.get("https://bridgetherapeutics.cliniops.com");
		Thread.sleep(3000);
		
		WebElement username= dr.findElement(By.id("username"));
		entertext(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		entertext(pwd, "welcome", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		ButtonClick(authBtn, "Authenticate Button");
		Thread.sleep(5000);
		WebElement errorMsg=dr.findElement(By.xpath("//*[text()='Authenitcation failed !']"));
		String error= errorMsg.getText();
		String expectedText="Authenitcation failed !";
		
		ErrorMessage(errorMsg, expectedText, error);
		System.out.println("Login:Testcase1 ended");
	
	}
	@Test(priority=2)
	public void sucessFulLogin1() throws IOException, InterruptedException{
		System.out.println("Login:Testcase2 started");
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement username= dr.findElement(By.id("username"));
		entertext(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		entertext(pwd, "Welcome123#", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		ButtonClick(authBtn, "Authenticate Button");
		Thread.sleep(3000);
		
		
		WebElement dd1=dr.findElement(By.id("investigator_study"));
		ButtonClick(dd1, "dropdown1 is clicked");
		WebElement opt1=dr.findElement(By.xpath("//*[text()='Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer']"));
		ButtonClick(opt1, "option1 is clicked");
		//dropDown(dd1, "5");
		Thread.sleep(3000);

		WebElement dd2=dr.findElement(By.id("lang_type"));
		ButtonClick(dd2, "dropdown2 is clicked");
		WebElement opt2=dr.findElement(By.xpath("//*[text()='English']"));
		ButtonClick(opt2, "option2 is clicked");
		//dropDown(dd1, "1");
				Thread.sleep(4000);
		
		WebElement clickLogin= dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		ButtonClick(clickLogin, "Login");

		System.out.println("Login:Testcase2 ended");


}
		 @Test(priority=3)
		 public void loginErrorMessage2() throws IOException, InterruptedException{
		  System.out.println("Login:Testcase3 started");
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  WebElement username= dr.findElement(By.id("username"));
		  entertext(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  entertext(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  ButtonClick(authBtn, "Authenticate Button");
		  WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  String error1= usererrorMsg.getText();
		  String expectedText1="Please enter the username";
		  ErrorMessage(usererrorMsg, expectedText1, error1);
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the password']"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  ErrorMessage(pwderrorMsg, expectedText2, error2);
			System.out.println("Login:Testcase3 ended");
	 }
		 
		 
		 @Test(priority=4)
		 public void loginErrorMessage3() throws IOException, InterruptedException{
		  System.out.println("Login:Testcase4 started");
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  entertext(username, "Abhishek", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  entertext(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  ButtonClick(authBtn, "Authenticate Button");
		  Thread.sleep(4000);	  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the password']"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  ErrorMessage(pwderrorMsg, expectedText2, error2);
		  Thread.sleep(3000);
			System.out.println("Login:Testcase4 ended");
		 }
		 
		 @Test(priority=5)
		 public void forgotPassword() throws IOException, InterruptedException{
				System.out.println("Login:Testcase5 started");
			 dr.get("https://bridgetherapeutics.cliniops.com");
			 
			 WebElement username= dr.findElement(By.id("username"));
			  entertext(username, "Abhishek", "Username field");
			 Thread.sleep(3000);
			 WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
			 forgotPwd.click();
			 Thread.sleep(3000);
			 WebElement email=dr.findElement(By.id("forgotemail"));
			 entertext(email, "abc@gmail.com", "Email id");
			 Thread.sleep(3000);
			 WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
			 ButtonClick(requestNewPwd, "Request new password");
			 Thread.sleep(3000);
			 WebElement emailIdError=dr.findElement(By.xpath("//*[text()='Email-id does not exist in database.']"));
			 String errorMsg=emailIdError.getText();
			 String actualErrorMsg="Email-id does not exist in database.";
			 ErrorMessage(emailIdError, actualErrorMsg, errorMsg);
			 Thread.sleep(3000);
			 WebElement backToLogin=dr.findElement(By.linkText("Back to Login"));
			 backToLogin.click();
			 Thread.sleep(5000);
				System.out.println("Login:Testcase5 ended");
		 }
		 @AfterMethod
		 public void CloseBrowser(){
			 dr.close();
		 }
		
		


	}

	

	

