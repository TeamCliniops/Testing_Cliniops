package com.testing.Cliniops;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import java.util.NoSuchElementException;
//import java.util.function.Function;
import com.google.common.base.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cliniops_AutomationScriptsTest extends Cliniops_ReusableMethodsTest{

WebDriver dr;
Wait<WebDriver> wait;

	@BeforeTest
	@Parameters("browser")
	public void Selectbrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			//System.setProperty("webdriver.firefox.marionette", "C:/Users/Zunaira's/Documents/QA automation/geckodriver-v0.16.1-win64/geckodriver.exe");
			//Ignore--This is added to check in github
			dr=new FirefoxDriver();	
			dr.manage().window().maximize();
			
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
	        
		}
		//dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		wait=new FluentWait(dr)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(4, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
		
		//wait.pollingEvery(2, TimeUnit.SECONDS);
		//wait.withTimeout(30, TimeUnit.SECONDS);
		//wait.ignoring(NoSuchElementException.class);
		
		
	}
	

	@Test
	public void loginErrorMessage1() throws IOException, InterruptedException{
		dr.get("https://bridgetherapeutics.cliniops.com");
		//Thread.sleep(3000);
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "welcome", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		clickObj(authBtn, "Authenticate Button");
		
		WebElement errorMsg=dr.findElement(By.className("error"));
		String error= errorMsg.getText();
		String expectedText="Please enter the user name";
		
		validateMsg(errorMsg, expectedText, error);
	
	}
	@Test
	public void sucessFulLogin1() throws IOException, InterruptedException{
		
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		//Thread.sleep(5000);
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		//Thread.sleep(5000);
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "Welcome123#", "Password field");
		
		//Thread.sleep(5000);
		//WebElement authBtn= dr.findElement(By.id("Authenticate"));
		//clickObj(authBtn, "Authenticate Button");
		
		WebElement authBtn=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver dr){
				return dr.findElement(By.id("Authenticate"));
			}
		});
		clickObj(authBtn, "Authenticate Button");
		
		//Thread.sleep(7000);
		//WebElement dd1=dr.findElement(By.id("investigator_study"));
		//dropDown(dd1, 1);
		
		WebElement dd1=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver dr){
				return dr.findElement(By.id("investigator_study"));
			}
		});
		dropDown(dd1, 1);
		
		
		//Thread.sleep(7000);
		
		
		//WebElement dd2=dr.findElement(By.id("lang_type"));
		WebElement dd2=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver dr){
				return dr.findElement(By.id("lang_type"));
			}
		});
		
		dropDown(dd2,1);
		//Thread.sleep(7000);
		
		
		WebElement clickLogin= dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		clickObj(clickLogin, "Login");
		//Thread.sleep(7000);

}

		@Test
		 public void loginErrorMessage2() throws IOException, InterruptedException{
		  
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  //Thread.sleep(4000);
		  
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  clickObj(authBtn, "Authenticate Button");
		  
		  WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  String error1= usererrorMsg.getText();
		  String expectedText1="Please enter the user name";
		  validateMsg(usererrorMsg, expectedText1, error1);
		  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the password']"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  validateMsg(pwderrorMsg, expectedText2, error2);
	 }
		 
		 
		 @Test
		 public void loginErrorMessage3() throws IOException, InterruptedException{
		  
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  //Thread.sleep(4000);
		  
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  clickObj(authBtn, "Authenticate Button");
		  
		  //WebElement usererrorMsg=dr.findElement(By.xpath("//*[text()='Please enter the username']"));
		  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[@id='login']/div[2]/label"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  validateMsg(pwderrorMsg, expectedText2, error2);
		  //Thread.sleep(3000);
		 }
		 
		 @Test
		 public void forgotPassword() throws IOException, InterruptedException{
			 
			 dr.get("https://bridgetherapeutics.cliniops.com");
			 
			 WebElement username= dr.findElement(By.id("username"));
			  enterText(username, "Abhishek", "Username field");
			 //Thread.sleep(3000);
			 
			 WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
			 forgotPwd.click();
			 //Thread.sleep(5000);
			 
			 WebElement email=dr.findElement(By.id("forgotemail"));
			 enterText(email, "abc@gmail.com", "Email id");
			 //Thread.sleep(3000);
			 
			 WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
			 clickObj(requestNewPwd, "Request new password");
			 //Thread.sleep(3000);
			 
			 WebElement emailIdError=dr.findElement(By.className("errorserver"));
			 String errorMsg=emailIdError.getText();
			 String actualErrorMsg="Email-id does not exist in database.";
			 validateMsg(emailIdError, actualErrorMsg, errorMsg);
			 //Thread.sleep(3000);
			 WebElement backToLogin=dr.findElement(By.linkText("Back to Login"));
			 backToLogin.click();
			 //Thread.sleep(5000);
		 }
		 
		@AfterTest
		
			public void closeBrowser(){
			dr.close();
		}


	}

	


