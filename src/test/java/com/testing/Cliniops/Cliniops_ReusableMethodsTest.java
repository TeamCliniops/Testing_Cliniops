
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
import org.openqa.selenium.WebElement;

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

	//Name of the method:entertext
	//Brief description:used to enter text into text box
	//arguments:obj->WebElement,textval->value to entered,objname->name of the object
	//created by:Automation team
	//creation date:12/15/2016
	//modified date:12/15/2016
	public static void entertext(WebElement obj,String textval,String objname) throws IOException{
		if(obj.isDisplayed())
		{obj.sendKeys(textval);
		Update_Report("Pass","entertext",textval+" is entered in "+objname);
		//System.out.println("Pass:"+textval+" is entered in "+objname);
		}
		else{
			Update_Report("Fail","entertext",objname+" field is not displayed,please check application");
			//System.out.println("Fail:"+objname+" field is not displayed,please check application");
		}
	}
	//Name of the method:ButtonClick
	//Brief description:used to click the button
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:12/15/2016
	//modified date:12/15/2016
	public static void ButtonClick(WebElement obj,String objname) throws IOException{
		if(obj.isDisplayed())
		{obj.click();
		Update_Report("Pass","ButtonClick",objname+" is clicked");
			//System.out.println("Pass:"+objname+" is clicked");
		}
		else{
			Update_Report("Fail","ButtonClick",objname+" is not displayed");
			//System.out.println("Fail:"+objname+" is not displayed");
			}	
	}
	//Name of the method:ErrorMessage
	//Brief description:used to display message on matching actual text with expected text
	//arguments:obj->WebElement,Expectedtext->text used to compare with actual text,objname->name of the object
	//created by:Automation team
	//creation date:12/15/2016
	//modified date:12/15/2016
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
	public static void TooltipValidation(WebElement obj,String Expectedtext,String Actualtext) throws IOException{
		if(obj.isDisplayed())
		{
			
			if(Expectedtext.trim().contains(Actualtext.trim())){
				Update_Report("Pass","ErrorMessage","Actual tool tip text: "+ Actualtext+" matching with expected text:"+Expectedtext);
				//System.out.println("Pass:Actual tooltip text matching with expected text:"+Actualtext);
				}
		else{Update_Report("Fail","ErrorMessage","Actual tool tip text: "+ Actualtext+" not matching with expected text:"+Expectedtext);
			//System.out.println("Fail:Actual tooltip text not matching with expected text"+Actualtext);
			}
		}
		else{Update_Report("Fail","ErrorMessage",obj+" is not displayed,please check your application");
			//System.out.println("Fail:"+obj+" is not displayed,please check your application");
			}
	}
	//Name of the method:Readingtext
	//Brief description:Reading text box value
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:12/15/2016
	//modified date:12/15/2016
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
	//Name of the method:readingCheckbox
	//Brief description:Reading check box value
	//arguments:obj->WebElement,objname->name of the object
	//created by:Automation team
	//creation date:12/15/2016
	//modified date:12/15/2016
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

	/* Method Name : readSheet
	 * Brief Desc: Read XL content
	 * Arguments: testDataPath --> Test Data path, sheetName --> Name of the Sheet
	 * Created By: Automation team	 * Creation Date: Dec 15th 2016
	 * Last Modified: Dec 15th 2016
	 * */
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
	//........................................
	
	/* Method Name : Writexlsheet
	 * Brief Desc: write data to  XL 
	 * Arguments: dtpath--> excelsheet path, sheetName --> Name of the Sheet,textval->value going to insert,i->rownum,j->columnnum
	 * Created By: Automation team
	 * Creation Date: Dec 16th 2016
	 * Last Modified: Dec 16th 2016
	 * */
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
				fout.close();}		

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
			+ " FireFox " + "</B></FONT></TD></TR>");
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

