package automationFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MDPRCreateDareToCareExecutive extends BaseClass  {

  @Test
	public void MDPRCreateDareToCare() throws Exception {
		TestExecution exeKey = new TestExecution();
		Properties prop;
		prop = new Properties();
		 System.out.println("started MDPRCreateDareToCare");
		 
		 
		
		try {
			String s1=System.getProperty("user.dir");
			System.out.println(s1);
          FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\automationFramework\\objectmap.properties");
          prop.load(fis);
          fis.close();
      }catch (IOException e) {
          System.out.println(e.getMessage());
      }
		
		ReadExcel.setExcelFile(Global.fileLocation+"MDPRequest.xls","MDPRDareToCareNewExecutive");
		for (int row = 1; row < ReadExcel.getRowCount(); row++) {
			List<Object> myParamList = new ArrayList<Object>();
			String methodName = ReadExcel.getCellData(row, 0);
			System.out.println("row:"+row);
			System.out.println(methodName);
			for (int col = 1; col < ReadExcel.getColumnCount(); col++) {
				if (!ReadExcel.getCellData(row, col).isEmpty()
						& !ReadExcel.getCellData(row, col).equals("null")) {
					if (col==1){
						String strElement=ReadExcel.getCellData(row, 1);
						 // retrieve the specified object from the object list
				        String locator = prop.getProperty(strElement);
				         
				        // extract the locator type and value from the object
				        String locatorType = locator.split(":")[0];
				        String locatorValue = locator.split(":")[1];	
				        myParamList.add(locatorType);
				        myParamList.add(locatorValue);
					}
					else {
					myParamList.add(ReadExcel.getCellData(row, col));
					}
			
					System.out.println("Col:"+col);
				}
				
			}
			String desc=ReadExcel.getCellData(row, 3);
			
			Object[] paramListObject = new String[myParamList.size()];
			paramListObject = myParamList.toArray(paramListObject);
			
			exeKey.runReflectionMethod("automationFramework.ReUsable",
					methodName, paramListObject);
			
		}
	//		ExtentTestManager.getTest().log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
		}
		
  }
  

  

