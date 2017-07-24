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
		Thread.sleep(2000);		
		tooltip1.moveToElement(usrname).build().perform();
		Thread.sleep(2000);
		actualTooltipText=usrname.getAttribute("title");
		expectedTooltipText="Enter Username";
		TooltipValidation(usrname, expectedTooltipText, actualTooltipText);
				
		WebElement password=dr.findElement(By.id("password"));
		Thread.sleep(2000);
		tooltip1.moveToElement(password).build().perform();
		Thread.sleep(2000);
		actualTooltipText=password.getAttribute("title");
		expectedTooltipText="Enter Password";
		TooltipValidation(password, expectedTooltipText, actualTooltipText);
		

		WebElement authenticate=dr.findElement(By.id("Authenticate"));
		Thread.sleep(2000);		
		tooltip1.moveToElement(authenticate).build().perform();
		Thread.sleep(2000);
		actualTooltipText=authenticate.getAttribute("title");
		expectedTooltipText="Authenticate";
		TooltipValidation(authenticate, expectedTooltipText, actualTooltipText);
		
		usrname.sendKeys("Abhishek");
		password.sendKeys("Welcome123#");
		authenticate.click();
		
		Thread.sleep(2000);		
		WebElement selectStudy=dr.findElement(By.id("investigator_study"));
		Thread.sleep(2000);		
		tooltip1.moveToElement(selectStudy).build().perform();
		Thread.sleep(2000);
		actualTooltipText=selectStudy.getAttribute("title");
		expectedTooltipText="Select Study";
		TooltipValidation(selectStudy, expectedTooltipText, actualTooltipText);
				
		Thread.sleep(2000);		
		WebElement selectLang=dr.findElement(By.id("lang_type"));
		Thread.sleep(2000);		
		tooltip1.moveToElement(selectLang).build().perform();
		Thread.sleep(2000);
		actualTooltipText=selectLang.getAttribute("title");
		expectedTooltipText="Select Language";
		TooltipValidation(selectLang, expectedTooltipText, actualTooltipText);
		
		WebElement loginBtn=dr.findElement(By.xpath(".//*[@id='login']/div[7]/input"));
		Thread.sleep(2000);		
		tooltip1 = new Actions(dr);
		tooltip1.moveToElement(loginBtn).build().perform();
		Thread.sleep(2000);
		actualTooltipText=loginBtn.getAttribute("title");
		expectedTooltipText="Login";
		TooltipValidation(loginBtn, expectedTooltipText, actualTooltipText);
		
		
	}
		
	@Test(priority=1)
	public void auto_clini_login_007() throws IOException, InterruptedException{
	dr.get("https://bridgetherapeutics.cliniops.com/login");
	WebElement usrname=dr.findElement(By.id("username"));
	entertext(usrname, "Abhishek", "username field");
	Thread.sleep(4000);
	WebElement usrname1=dr.findElement(By.id("username"));
	System.out.println(usrname1.getText());
	ReadingText(usrname1,"user name");
	
	}

	@Test(priority=2)
	public void auto_clini_login_008() throws IOException{
	dr.get("https://bridgetherapeutics.cliniops.com/login");
	WebElement password=dr.findElement(By.id("password"));
	entertext(password, "Welcome123#", "password field");
	WebElement password1=dr.findElement(By.id("password"));
	String password2=password.getText();
	String expectedPassword="***********";
	ErrorMessage(password,expectedPassword,password2);
	}
	
	@Test(priority=3)
	public void auto_clini_login_009() throws IOException{
		dr.get("https://bridgetherapeutics.cliniops.com/login");
		WebElement selectstudy=dr.findElement(By.id("investigator_study"));
		Checkdisabled(selectstudy,"Select Study");			
	}
		 @AfterMethod
		 public void CloseBrowser(){
			 dr.close();
		 }
		
		


	}

	

	

