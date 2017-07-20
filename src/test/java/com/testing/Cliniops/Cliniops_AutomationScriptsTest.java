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
import org.openqa.selenium.interactions.Actions;
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

	//@BeforeTest
	//@Parameters("browser")
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
	        dr=new InternetExplorerDriver();
	        dr.manage().window().maximize();
	        
		}
		
		wait=new FluentWait(dr)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(4, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
		
	}
	
	public void auto_clini_login_001() throws Exception{
		String expectedTooltipText;
		String actualTooltipText;
		Actions tooltip1;
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement usrname=dr.findElement(By.id("username"));
		Thread.sleep(5000);
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(usrname).build().perform();
		Thread.sleep(5000);
		actualTooltipText=usrname.getAttribute("title");
		expectedTooltipText="Enter Username";
		if(expectedTooltipText.equals(actualTooltipText)){
			System.out.println("Pass:Tooltip for Username displayed Successfully");
		}
		
		WebElement password=dr.findElement(By.id("password"));
		Thread.sleep(5000);
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(password).build().perform();
		Thread.sleep(5000);
		actualTooltipText=password.getAttribute("title");
		expectedTooltipText="Enter Password";
		if(expectedTooltipText.equals(actualTooltipText)){
			System.out.println("Pass:Tooltip for password displayed Successfully");
		}
		

		WebElement authenticate=dr.findElement(By.id("Authenticate"));
		Thread.sleep(5000);
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(authenticate).build().perform();
		Thread.sleep(5000);
		actualTooltipText=authenticate.getAttribute("title");
		expectedTooltipText="Authenticate";
		if(expectedTooltipText.equals(actualTooltipText)){
			System.out.println("Pass:Tooltip for Authenticate button displayed Successfully");
		}
		
		usrname.sendKeys("Abhishek");
		password.sendKeys("Welcome123#");
		authenticate.click();
		
		WebElement selectLang=dr.findElement(By.id("lang_type"));
		Thread.sleep(5000);
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(authenticate).build().perform();
		Thread.sleep(5000);
		actualTooltipText=selectLang.getAttribute("title");
		expectedTooltipText="Select Language";
		if(expectedTooltipText.equals(actualTooltipText)){
			System.out.println("Pass:Tooltip for Select Language Dropdown displayed Successfully");
		}
		
		WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		Thread.sleep(5000);
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(loginBtn).build().perform();
		Thread.sleep(5000);
		actualTooltipText=loginBtn.getAttribute("title");
		expectedTooltipText="Login";
		if(expectedTooltipText.equals(actualTooltipText)){
			System.out.println("Pass:Tooltip for Login button displayed Successfully");
		}
		
		
	}
	

	//@Test
	public void loginErrorMessage1() throws IOException, InterruptedException{
		System.out.println("TestCase1 Started!!!");
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "welcome", "Password field");
		
		WebElement authBtn= dr.findElement(By.id("Authenticate"));
		ButtonClick(authBtn, "Authenticate Button");
		
		WebElement errorMsg=dr.findElement(By.className("error"));
		String error= errorMsg.getText();
		String expectedText="Authenitcation failed !";
		
		ErrorMessage(errorMsg, expectedText, error);
		System.out.println("Testcase1 Ended!!!");
	}
	//@Test
	public void sucessFulLogin1() throws IOException, InterruptedException{
		System.out.println("TestCase2 Started!!!");
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement username= dr.findElement(By.id("username"));
		enterText(username, "Abhishek", "Username field");
		
		WebElement pwd= dr.findElement(By.id("password"));
		enterText(pwd, "Welcome123#", "Password field");
		
	
		WebElement authBtn=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver dr){
				return dr.findElement(By.id("Authenticate"));
			}
		});
		ButtonClick(authBtn, "Authenticate Button");
		
		WebElement dd1=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver dr){
				return dr.findElement(By.id("investigator_study"));
			}
		});
		dropDown(dd1, 1);
		WebElement dd2=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver dr){
				return dr.findElement(By.id("lang_type"));
			}
		});
		dropDown(dd2,1);
		WebElement clickLogin= dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		ButtonClick(clickLogin, "Login");
		System.out.println("Testcase2 Ended!!!");
}

		//@Test
		 public void loginErrorMessage2() throws IOException, InterruptedException{
			System.out.println("TestCase3 Started!!!");
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  
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
		  System.out.println("Testcase3 Ended!!!");
	}
		 
		 
		 //@Test
		 public void loginErrorMessage3() throws IOException, InterruptedException{
			 System.out.println("TestCase4 Started!!!");
		  dr.get("https://bridgetherapeutics.cliniops.com");
		  
		  WebElement username= dr.findElement(By.id("username"));
		  enterText(username, "", "Username field");
		  
		  WebElement pwd= dr.findElement(By.id("password"));
		  enterText(pwd, "", "Password field");
		  
		  WebElement authBtn= dr.findElement(By.id("Authenticate"));
		  ButtonClick(authBtn, "Authenticate Button");
		  
		  WebElement pwderrorMsg=dr.findElement(By.xpath("//*[@id='login']/div[2]/label"));
		  String error2= pwderrorMsg.getText();
		  String expectedText2="Please enter the password";
		  ErrorMessage(pwderrorMsg, expectedText2, error2);
		  System.out.println("Testcase4 Ended!!!");
		 }
		 
		 //@Test
		 public void forgotPassword() throws IOException, InterruptedException{
			 System.out.println("TestCase5 Started!!!");
			 dr.get("https://bridgetherapeutics.cliniops.com");
			 
			 WebElement username= dr.findElement(By.id("username"));
			  enterText(username, "Abhishek", "Username field");
			 
			 WebElement forgotPwd=dr.findElement(By.linkText("Forgot password..? Click here..."));
			 forgotPwd.click();
			 
			 WebElement email=dr.findElement(By.id("forgotemail"));
			 enterText(email, "abc@gmail.com", "Email id");
			 
			 WebElement requestNewPwd=dr.findElement(By.id("req_new_pass"));
			 ButtonClick(requestNewPwd, "Request new password");
			 
			 WebElement emailIdError=dr.findElement(By.className("errorserver"));
			 String errorMsg=emailIdError.getText();
			 String actualErrorMsg="Email-id does not exist in database.";
			 ErrorMessage(emailIdError, actualErrorMsg, errorMsg);
	
			 WebElement backToLogin=dr.findElement(By.linkText("Back to Login"));
			 backToLogin.click();
			 System.out.println("Testcase5 Ended!!!");
		 }
		 
		//@AfterTest
		
			public void CloseBrowser(){
			dr.close();
		}


	}

	


