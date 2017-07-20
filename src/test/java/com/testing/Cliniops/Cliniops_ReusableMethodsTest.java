package com.testing.Cliniops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cliniops_ReusableMethodsTest { 
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	/* 
	 * Name of the Method: enterText
	 * Brief description : Enter text into text box field
	 * Arguments: obj --> Webelement Object, textval --> Text to be entered, objName --> name of hte object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  2017
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			System.out.println("Pass "+ "enterText:"+textVal + " is entered in " + objName);
			
		}else{
			System.out.println("Fail "+ "enterText:"+objName + " field is not displayed, please check your application.");
			
		}

	}
	/* 
	 * Name of the Method: dropDown
	 * Brief description : Selecting the DropDown
	 * Arguments: obj --> Webelement Object, textval --> Text to be entered 
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified:  July 17 2017
	 * */
	public static void dropDown(WebElement dd, int index){
		
		Select select = new Select(dd);
		if(dd.isDisplayed()){
			select.selectByIndex(index);
			System.out.println("Pass" +dd+ "is selected");
		}
			else{
				System.out.println("Fail" +dd + "is not displayed");
			}
		
	}

	/* 
	 * Name of the Method: clickObj
	 * Brief description : click object
	 * Arguments: obj --> Webelement Object,  objName --> name of the object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified: July 17 2017
	 * 
	 * */	
	public static void ButtonClick(WebElement obj, String objname)throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass","ButtonClick",objname+" is clicked");
			//System.out.println("Pass: "+ objName + " is clicked.");
		}else{
			Update_Report("Fail","ButtonClick",objname+" is not displayed");
			//System.out.println("Fail: " + objName+ " is not displayed, please check your application");
		}
		/*final WebDriverWait wait=new WebDriverWait(dr,30);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.id("Authenticate"))));
		dr.findElement(By.id("Authenticate")).click();
		*/
		
	}

	/* 
	 * Name of the Method: validateMsg
	 * Brief description : validate message displayed on the web page
	 * Arguments: obj --> Webelement Object,  expectedText --> expected text to be displayed, objName --> name of hte object
	 * Created by: Automation team
	 * Creation date : July 17 2017
	 * last modified: July 17 2017
	 * 
	 * */	

	/*public static void validateMsg(WebElement obj, String expectedText, String objName){
		if(obj.isDisplayed()){
			String actualText = obj.getText().trim();
			if(expectedText.equals(actualText)){
				System.out.println("Pass: Actual message is matching with expected message " + actualText);
			}else{
				System.out.println("Fail: Actual message '" + actualText + "' is not matching with expected message '"+ expectedText+"'  ,Please check your application");
			}
		}else{
			System.out.println("Fail: " + objName+ " is not displayed, please check your application");
		}
	}*/
	public static void ErrorMessage(WebElement obj,String Expectedtext,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			String Actualtext=obj.getText().trim();
			if(Expectedtext.trim().contains(Actualtext.trim())){
				Update_Report("Pass","ErrorMessage","Actual message matching with expected message:"+Actualtext);
				//System.out.println("Pass:Actual message matching with expected message:"+Actualtext);
				}
		else{Update_Report("Fail","ErrorMessage","Actual message not matching with expected message:"+Actualtext);
			//System.out.println("Fail:Actual message not matching with expected message"+Actualtext);
			}
		}
		else{Update_Report("Fail","ErrorMessage",objname+" is not displayed,please check your application");
			//System.out.println("Fail:"+objname+" is not displayed,please check your application");
			}
	}
	
	public static void ReadingText(WebElement obj,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			String Actualtext=obj.getText().trim();
			if(Actualtext.isEmpty()){Update_Report("Fail","ReadingText",objname+" has No data");
				//System.out.println("Fail:"+objname+" has No data");
				}
		else{Update_Report("Pass","ReadingText",objname+" contains "+Actualtext);
			//System.out.println("Pass:"+objname+" contains "+Actualtext);
			}
		}
	}	
	
	public static void readingCheckbox(WebElement obj,String Expectedtext,String objname) throws IOException{
		if(obj.isDisplayed())
		{
			String Actualtext=obj.getAttribute("checked").trim();
			if(Expectedtext.equals(Actualtext)){
				Update_Report("Pass","readingCheckbox",objname+" is checked");
				//System.out.println("Pass:"+objname+" is checked");
				}
		else{Update_Report("Fail","readingCheckbox",objname+" is not checked");
			//System.out.println("Fail:"+objname+" is not checked");
			}
		}
		else{Update_Report("Fail","readingCheckbox",objname+" is not displayed,please check your application");
			//System.out.println("Fail:"+objname+" is not displayed,please check your application");
			}
	}
	
	public static String[][] ReadExcelSheet(String dtpath,String Sheetname) throws Exception{
		/*Step 1: Get the XL Path*/
				File xlfile=new File(dtpath);
		/*Step2: Access the XL File*/
				FileInputStream xldoc=new FileInputStream(xlfile);
		/*Step3: Access the work book */
				HSSFWorkbook wb=new HSSFWorkbook(xldoc);
		/*Step4: Access the Sheet */
				HSSFSheet sheet=wb.getSheet(Sheetname);
				int irowcount=sheet.getLastRowNum()+1;
				int icolumncount=sheet.getRow(0).getLastCellNum();
				System.out.println("Row Count:"+irowcount+" and Column Count:"+icolumncount);
				String[][] xldata= new String[irowcount][icolumncount];
				for(int i=0;i<irowcount;i++)
				{for(int j=0;j<icolumncount;j++)
					{xldata[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();				
					}
				}
				return xldata;
			}
public static void Writexlsheet(String dtpath, String sheetname, String textval, int i, int j) throws IOException {
		
		File xlfile=new File(dtpath);
		/*Step2: Access the XL File*/
				FileInputStream xldoc=new FileInputStream(xlfile);
		/*Step3: Access the work book */
				HSSFWorkbook wb=new HSSFWorkbook(xldoc);
		/*Step4: Access the Sheet */
				HSSFSheet sheet=wb.getSheet(sheetname);
				HSSFRow  row=sheet.getRow(i);
				HSSFCell cell= row.getCell(j);
				cell.setCellValue(textval);
				//HSSFCellStyle titlestyle=wb.createCellStyle();
				//titlestyle.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
				//titlestyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				//cell.setcellstyle(titlestyle);
				
				FileOutputStream fout=new  FileOutputStream(dtpath);
				wb.write(fout);
				fout.flush();
				fout.close();
	}

/* Method Name : WritexlsheetColor
 * Brief Desc: ChangeExcelsheet Cell Color 
 * Arguments: dtpath--> excelsheet path, sheetName --> Name of the Sheet,textval->value pass/fail based on matcing in 2 sheets,i->rownum,j->columnnum
 * Created By: Automation team
 * Creation Date: Dec 17th 2016
 * Last Modified: Dec 17th 2016
 * */
public static void WritexlsheetColor(String dtpath, String sheetname,int i, int j,String val) throws IOException {
	
	File xlfile=new File(dtpath);
	/*Step2: Access the XL File*/
			FileInputStream xldoc=new FileInputStream(xlfile);
	/*Step3: Access the work book */
			HSSFWorkbook wb=new HSSFWorkbook(xldoc);
	/*Step4: Access the Sheet */
			HSSFSheet sheet=wb.getSheet(sheetname);
			HSSFRow  row=sheet.getRow(i);
			HSSFCell cell= row.getCell(j);
			HSSFCellStyle titlestyle=wb.createCellStyle();
			if(val.equals("pass")){
			titlestyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titlestyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titlestyle);}
			else
			{titlestyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titlestyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titlestyle);}
			
			FileOutputStream fout=new  FileOutputStream(dtpath);
			wb.write(fout);
			fout.flush();
			fout.close();
		}

public static void startReport(String scriptName, String ReportsPath) throws IOException{

	String strResultPath = null;


	String testScriptName =scriptName;


	cur_dt = new Date(); 
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	String strTimeStamp = dateFormat.format(cur_dt);

	if (ReportsPath == "") { 

		ReportsPath = "C:\\";
	}

	if (ReportsPath.endsWith("\\")) { 
		ReportsPath = ReportsPath + "\\";
	}

	strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
	File f = new File(strResultPath);
	f.mkdirs();
	htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
			+ ".html";



	bw = new BufferedWriter(new FileWriter(htmlname));

	bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
			+ "FireFox " + "</B></FONT></TD></TR>");
	bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
			+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
			+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
			+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
			+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


}


public static void Update_Report(String Res_type,String Action, String result) throws IOException {
	String str_time;
	Date exec_time = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	str_time = dateFormat.format(exec_time);
	if (Res_type.startsWith("Pass")) {
		bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
				+ (j++)
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+Action
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+ str_time
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
				+ "Passed"
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
				+ result + "</FONT></TD></TR>");

	} else if (Res_type.startsWith("Fail")) {
		exeStatus = "Failed";
		report = 1;
		bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
				+ (j++)
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+Action
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
				+ str_time
				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ "<a href= "
				+ htmlname
				+ "  style=\"color: #FF0000\"> Failed </a>"

			+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
			+ result + "</FONT></TD></TR>");
			

	} 
}


	
	
}
//}