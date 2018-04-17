package automationFramework;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestExecution  {
	
		

	
	public void runReflectionMethod (String strClassName, String strMethodName, 
			Object... inputArgs) throws Exception {
	
		Class<?> params[] = new Class[inputArgs.length];

		for (int i = 0; i < inputArgs.length; i++) {
			if (inputArgs[i] instanceof String ) {
				params[i] = String.class;
			}
		}
		
		try {
			Class<?> cls = Class.forName(strClassName);
			Object _instance = cls.newInstance();
			Method myMethod = cls.getDeclaredMethod(strMethodName, params);
	//		System.out.println(inputArgs[inputArgs.length-2]);
			Object o = myMethod.invoke(_instance, inputArgs);
			String result=o.toString();
			if(result=="Pass"){
				ExtentTestManager.getTest().log(LogStatus.PASS, inputArgs[inputArgs.length-2]+" "+result);
			}
			else{
				ExtentTestManager.getTest().log(LogStatus.FAIL, inputArgs[inputArgs.length-2]+" "+result);
				 throw new Exception("Failure: "+inputArgs[inputArgs.length-2]); 
			}
			
		} catch (ClassNotFoundException e) {
			System.err.format(strClassName + ":- Class not found%n");
		} catch (IllegalArgumentException e) {
			System.err
					.format("Method invoked with wrong number of arguments%n");
		} catch (NoSuchMethodException e) {
			System.err.format("In Class " + strClassName + "::" + strMethodName
					+ ":- method does not exists%n");
		} catch (InvocationTargetException e) {
			System.err.format("Exception thrown by an invoked method%n");
		} catch (IllegalAccessException e) {
			System.err
					.format("Can not access a member of class with modifiers private%n");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err
					.format("Object cannot be instantiated for the specified class using the newInstance method%n");
		} 
	}
/*	
@Test
	public void AorticForm() throws Exception {
		TestExecution exeKey = new TestExecution();
		Properties prop;
		prop = new Properties();
		test = extent.startTest("AorticForm");
			
		
		try {
			String s1=System.getProperty("user.dir");
			System.out.println(s1);
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\automationFramework\\objectmap.properties");
            prop.load(fis);
            fis.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
		ReadExcel.setExcelFile("C:/Users/chavaj6/Desktop/TestCases/testCaseSheet.xls","Test Cases");
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

			
			Object[] paramListObject = new String[myParamList.size()];
			paramListObject = myParamList.toArray(paramListObject);

			exeKey.runReflectionMethod("automationFramework.ReUsable",
					methodName,test, paramListObject);
		}
	}
*/	
	
}
