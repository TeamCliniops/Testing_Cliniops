package com.testing.Cliniops;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
					
		
	}
	@Test(priority=0)
	public void auto_clini_login_001() throws Exception{
		String expectedTooltipText;
		String actualTooltipText;
		Actions tooltip1=new Actions(dr);
		dr.get("https://bridgetherapeutics.cliniops.com");
		
		WebElement usrname=dr.findElement(By.id("username"));
		//new FluentWait(dr).withTimeout(100, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS);
		Thread.sleep(2000);		
		tooltip1.moveToElement(usrname).build().perform();
		Thread.sleep(2000);
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		actualTooltipText=usrname.getAttribute("title");
		expectedTooltipText="Enter Username";
		TooltipValidation(usrname, expectedTooltipText, actualTooltipText);
		
		
		WebElement password=dr.findElement(By.id("password"));
		Thread.sleep(2000);
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		tooltip1.moveToElement(password).build().perform();
		Thread.sleep(2000);
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		actualTooltipText=password.getAttribute("title");
		expectedTooltipText="Enter Password";
		TooltipValidation(password, expectedTooltipText, actualTooltipText);
		

		WebElement authenticate=dr.findElement(By.id("Authenticate"));
		Thread.sleep(2000);		
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		tooltip1.moveToElement(authenticate).build().perform();
		Thread.sleep(2000);
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		actualTooltipText=authenticate.getAttribute("title");
		expectedTooltipText="Authenticate";
		TooltipValidation(authenticate, expectedTooltipText, actualTooltipText);
		
		entertext(usrname, "Abhishek", "username field");
		entertext(password, "Welcome123#", "Password field");
		ButtonClick(authenticate, "Authenticate Button");
		
		//Thread.sleep(2000);		
		WebDriverWait wait = new WebDriverWait(dr, 15);
		wait.until(ExpectedConditions.elementToBeClickable(authenticate));
		WebElement selectLang=dr.findElement(By.id("lang_type"));
		Thread.sleep(2000);		
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		tooltip1.moveToElement(authenticate).build().perform();
		Thread.sleep(2000);
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		actualTooltipText=selectLang.getAttribute("title");
		expectedTooltipText="Select Language";
		TooltipValidation(selectLang, expectedTooltipText, actualTooltipText);
		
		WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		Thread.sleep(2000);		
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(loginBtn).build().perform();
		Thread.sleep(2000);
		//dr.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		actualTooltipText=loginBtn.getAttribute("title");
		expectedTooltipText="Login";
		TooltipValidation(loginBtn, expectedTooltipText, actualTooltipText);
		
		
	}
	


	
	@Test(priority=1,enabled=false)
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
	@Test(priority=2,enabled=false)
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
		 @Test(priority=3,enabled=false)
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
		 
		 
		 @Test(priority=4,enabled=false)
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
		 
		 @Test(priority=5,enabled=false)
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

	

	

