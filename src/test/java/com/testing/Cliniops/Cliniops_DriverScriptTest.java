package com.testing.Cliniops;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class Cliniops_DriverScriptTest  {
@Test
	public static void DriverscriptExecution() throws Exception{
		Cliniops_AutomationScriptsTest CAS=new Cliniops_AutomationScriptsTest();
	
		String dtpath="C:\\Users\\Naresh\\Cliniops_Workspace\\Cliniops_Project\\cliniops_AutomationScripts_Execution.xls";
		String ReportsPath="C:\\Users\\Naresh\\Cliniops_Workspace\\Cliniops_Project\\test-output\\Suite\\Report\\";
		//String dtpath="C:\\Users\\Naresh\\Desktop\\CliniopsScriptsExecution.xls";
		//String ReportsPath="C:\\Users\\Naresh\\Desktop\\Report";
		String Sheet="Sheet1";
		String[][] recData = Cliniops_ReusableMethodsTest.ReadExcelSheet(dtpath, Sheet);
		for(int i=0; i<recData.length; i++){ 

				if (recData[i][1].equalsIgnoreCase("y")){ 
					String  testname = recData[i][2]; 
					System.out.println("Testcase to run: "+recData[i][2]); 
     			Method testcase = Cliniops_AutomationScriptsTest.class.getMethod(testname);
     			Cliniops_ReusableMethodsTest.startReport(testname, ReportsPath);
				if(recData[i][3].equalsIgnoreCase("Y")){ 
					CAS.Selectbrowser("firefox"); 
					testcase.invoke(CAS); 
					CAS.CloseBrowser(); 
					Cliniops_ReusableMethodsTest.bw.close();
				} 
				if(recData[i][4].equalsIgnoreCase("Y")){ 
					CAS.Selectbrowser("chrome"); 
						testcase.invoke(CAS); 
						CAS.CloseBrowser(); 
						Cliniops_ReusableMethodsTest.bw.close();
					} 
				if(recData[i][5].equalsIgnoreCase("Y")){ 
					CAS.Selectbrowser("IE"); 
						testcase.invoke(CAS); 
						CAS.CloseBrowser();
						Cliniops_ReusableMethodsTest.bw.close();}
					} 
				else if(recData[i][1].equalsIgnoreCase("n"))

System.out.println(recData[i][2]+" in line number "+i+" skipped from execution");
				}
	}}

		
		