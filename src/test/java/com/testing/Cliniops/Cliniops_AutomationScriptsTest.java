package com.testing.Cliniops;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr;

	//@BeforeTest
    @BeforeMethod
	@Parameters({"browser"})
	public void Selectbrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			dr=new FirefoxDriver();	
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("chrome")){
		
			dr=new ChromeDriver();
			dr.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("IE")){


			// Create object of DesiredCapabilities class

			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();

			// Set ACCEPT_SSL_CERTS  variable to true
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        //dr=new InternetExplorerDriver(cap);
			dr=new InternetExplorerDriver();
	        dr.manage().window().maximize();
	        
		}
		
	}
	

	@Test (enabled = false)
	public void loginErrorMessage1() throws IOException, InterruptedException{
		System.out.println("check1.....");
		//dr = new FirefoxDriver();
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		Thread.sleep(3000);
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		Thread.sleep(5000);
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "welcome", "Password field");
		Thread.sleep(10000);
		
		WebElement authBtn = dr.findElement(By.xpath(".//*[@id='Authenticate']"));
		authBtn.click();
		
		
		WebDriverWait wait = new WebDriverWait(dr, 30);
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='role']/label[2]")));
		//WebElement errorMsg=dr.findElement(By.xpath(".//*[@id='role']/label[2]"));
		//WebElement errorMsg=dr.findElement(By.className("error"));
		String error= errorMsg.getText();
		String expectedText="Authenitcation failed !";
		
		ErrorMessage(errorMsg, expectedText, error);
	
	}
	@Test //(enabled = false)
	public void sucessFulLogin1() throws IOException, InterruptedException{
		
		//dr = new FirefoxDriver();
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		//dr.manage().window().maximize();
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "Welcome123#", "Password field");
		Thread.sleep(5000);
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		ButtonClick(authBtn, "Authenticate Button");
		Thread.sleep(10000);
		
		
		WebElement dd1=dr.findElement(By.id("investigator_study"));
		dropDown(dd1, 1);
		
		//selectByVisibleText("Cisplatin/Etoposide/Rad................-Small Cell Lung Cancer");
		Thread.sleep(5000);
		
		WebElement dd2=dr.findElement(By.id("lang_type"));
		dropDown(dd2, 1);
//		Select select = new Select(dd2);
//		select.selectByValue("1");
		
		Thread.sleep(10000);

		dr.findElement(By.xpath(".//*[@id='login']//input[@title='Login']")).click();
		System.out.println("logged in successfully");
		Thread.sleep(5000);
		
		//verifying login page 
		String actual = dr.findElement(By.xpath(".//*[@id='header-right']/div/span")).getText();
		String expected = "Cisplatin/Etoposide/Radio...Small Cell Lung Cancer";
		if(actual.equals(expected)){
			System.out.println("logged in successfully....");
		}
		else{
			System.out.println("failed to logged in......");
		}

}
		 @Test// (enabled = false)//(priority = 2)
		 public void loginErrorMessage2() throws IOException, InterruptedException{
			// dr = new FirefoxDriver();
		  
		  dr.get("https://bridgetherapeutics.cliniops.com");
			//dr.manage().window().maximize();
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  ButtonClick(authBtn, "Authenticate Button");
		  WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  String error1= usererrorMsg.getText();
		  String expectedText1="Please enter the user name";
		  ErrorMessage(usererrorMsg, expectedText1, error1);
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the password']"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  ErrorMessage(pwderrorMsg, expectedText2, error2);
	 }
		 
		 
		 @Test//(enabled = false) //(priority = 3)
		 public void loginErrorMessage3() throws IOException, InterruptedException{
			 
			// dr = new FirefoxDriver();
		  dr.get("https://bridgetherapeutics.cliniops.com");
			//dr.manage().window().maximize();
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "Abhishek", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  Thread.sleep(4000);
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  ButtonClick(authBtn, "Authenticate Button");
		  //WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[@id='login']/div[2]/label"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  ErrorMessage(pwderrorMsg, expectedText2, error2);
		  Thread.sleep(3000);
		 }
		 
		 @Test// (enabled = false)// (priority = 4)
		 public void forgotPassword() throws IOException, InterruptedException{
			 
			// dr = new FirefoxDriver();
			 dr.get("https://bridgetherapeutics.cliniops.com");
			// dr.manage().window().maximize();
			 
			 WebElement username= dr.findElement(By.id("username"));
			  enterText(username, "Abhishek", "Username field");
			 Thread.sleep(10000);
			 WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
			 //WebElement forgotPwd=dr.findElement(By.xpath(".//*[@id='login']/div[3]/a"));
			 forgotPwd.click();
			 Thread.sleep(3000);
			 WebElement email=dr.findElement(By.id("forgotemail"));
			 enterText(email, "abc@gmail.com", "Email id");
			 Thread.sleep(3000);
			 WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
			 clickObj(requestNewPwd, "Request new password");
			 Thread.sleep(3000);
			 WebElement emailIdError=dr.findElement(By.className("errorserver"));
			 String errorMsg=emailIdError.getText();
			 String actualErrorMsg="Email-id does not exist in database.";
			 ErrorMessage(emailIdError, actualErrorMsg, errorMsg);
			 Thread.sleep(3000);
			 WebElement backToLogin=dr.findElement(By.linkText("Back to Login"));
			 backToLogin.click();
			 Thread.sleep(5000);
		 }
		 
		@AfterMethod
		
			public void closeBrowser(){
			dr.close();
		}


	}

	


