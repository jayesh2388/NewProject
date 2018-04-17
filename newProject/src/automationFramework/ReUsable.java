package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class ReUsable extends BaseClass  {
	static WebDriver driver;
	static WebDriverWait wait;
	static String driverPath = "C:/Users/Jayesh/Desktop/ChromeDriver/chromedriver.exe";
	static String pass="Pass";
	static String fail="Fail";
/*	protected ExtentReports extent;
    public  static ExtentTest test;
    final String filePath = "C:\\Users\\chavaj6\\Desktop\\Results\\"+"Extent.html";
	
 */   
   
	
	public String  open_Browser(String browserName, String result, String sshot) throws Exception  {
		
		try{
			if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				return pass;
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						driverPath);
				driver = new ChromeDriver();
				//ExtentTestManager.getTest().log(LogStatus.PASS, result);
				return pass;
			}else {
				//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
				return fail;
			}
			
		} catch(Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			return fail;
		}
	}

	
	public String  save_RecordURL(String fName, String result, String sshot) throws Exception  {
		
		try{
			PrintWriter out = new PrintWriter(fName);
			String recURL= driver.getCurrentUrl();
			out.println(recURL);
			out.close();
			return pass;
		
			
		} catch(Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			
			return fail;
		}
	}


	
	public String open_RecURL(String fileName,String result, String sshot) {
		try{
		FileReader fileReader = 
	    new FileReader(fileName);
    // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String URL = bufferedReader.readLine();
		driver.navigate().to(URL);
		//ExtentTestManager.getTest().log(LogStatus.PASS, result);
		bufferedReader.close();
		return pass;
		}
		catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			
			return fail;
		}
	}

	public String enter_URL(String URL,String result, String sshot) {
		try{
		driver.navigate().to(URL);
		//ExtentTestManager.getTest().log(LogStatus.PASS, result);
		return pass;
		}
		catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			return fail;
		}
	}

	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public String login(String str1, String result, String sshot){
		try{
		//login
		System.out.println("In Login method");
		 String loginId = str1.split(":")[0];
		 String str2 = str1.split(":")[1];
	     String password = str2.split("=")[0];
	  
	     String uname=str1.split("=")[1];
	     System.out.println(loginId+" "+password+" "+uname);
	     driver.findElement(By.name("username")).sendKeys(loginId);   
	     driver.findElement(By.name("pw")).sendKeys(password);  
	     driver.findElement(By.name("Login")).click(); 
	     System.out.println("clicked in login"+uname);
//Wait     
	     WebDriverWait wait=new WebDriverWait(driver,20);
//Wait till the element is not visible
	   
	     WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("str")));
	     element.sendKeys(uname);
	     driver.findElement(By.id("phSearchButton")).click(); 
	   	 WebElement parentElement = driver.findElement(By.className("displayName"));
	 	 WebElement childElement = parentElement.findElement(By.linkText(uname));
	 	 childElement.click();
	 	 Thread.sleep(5000);
	 	 driver.findElement(By.cssSelector("a#moderatorMutton")).click(); 
	     driver.findElement(By.id("USER_DETAIL")).click(); 
	     driver.findElement(By.name("login")).click();

	     //ExtentTestManager.getTest().log(LogStatus.PASS, result);
	     return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println(e);
			return fail;
		}
	}
	
	public String enter_Text(String locatorType, String value, String text, String result, String sshot) {
		try {
			String text1;
			String text2;
			if (text.contains("+")){
				String currDate = text.split("\\+")[0];
				String days = text.split("\\+")[1];
				int foo = Integer.parseInt(days);	
				text1=myMethods.calcDate(foo);		
				}else if (text.contains("Current Date")){
					text1=myMethods.calcDate(0);
									
				}else
				text1=text;
			if (text1.contains("Date")){
				String temp1=myMethods.getDate();
				text2=text1+temp1;
			}
			else
				text2=text1;
			By locator;
			locator = locatorValue(locatorType, value);
			 WebDriverWait wait1=new WebDriverWait(driver,20);
		     wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			element.clear();
			element.sendKeys(text2);
			//ExtentTestManager.getTest().log(LogStatus.PASS, result);
			return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println(e);
			return fail;
		}
	}
	public String check_Error(String locatorType, String value, String data, String result, String sshot) {
		try {
			By locator;
	//		 System.out.println("Started check error1");
			locator = locatorValue(locatorType, value);
//			System.out.println("after locating");
			WebElement element = driver.findElement(locator);
//			System.out.println("after finding");
			String error1= element.getText();
//			System.out.println("after getting text");
			if (error1.contains(data)){
//		    	 System.out.println("Error Displayed correctly:"+error1); 
		    	 return pass;
		     	}  
			else
			{
//				System.out.println("Wrong error:"+error1); 
				return fail;
			}	
			//ExtentTestManager.getTest().log(LogStatus.PASS, result);
			
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
		}
	}

	public String verify_FieldText(String locatorType, String value, String data, String result, String sshot) {
		try {
			By locator;
			String text1;
			String text2;
			
			//		 System.out.println("Started check error1");
			locator = locatorValue(locatorType, value);
//			System.out.println("after locating");
			WebElement element = driver.findElement(locator);
//			System.out.println("after finding");
			text1= element.getText();
//			System.out.println("after getting text");
			if (data.contains("Date")){
				String temp1=myMethods.getDate();
				text2=data+temp1;
			}
			else
				text2=data;
			
			
			
			if (text1.contains(text2)){
//		    	 System.out.println("Error Displayed correctly:"+error1); 
		    	 return pass;
		     	}  
			else
			{
//				System.out.println("Wrong error:"+error1); 
				return fail;
			}	
			//ExtentTestManager.getTest().log(LogStatus.PASS, result);
			
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
		}
	}
	
	
	public String click_On_Link(String locatorType, String value, String result, String sshot) {
		try {
			String text1;
			
			By locator;
			if (value.contains("Date")){
				String temp1=myMethods.getDate();
				text1=value+temp1;
			}
			else
				text1=value;
			
			
			locator = locatorValue(locatorType, text1);
			WebElement element = driver.findElement(locator);
			element.click();
			//ExtentTestManager.getTest().log(LogStatus.PASS, result);
			return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
		}
	}

	public String click_On_Button(String locatorType, String value, String result, String sshot) {
		try {
			System.out.println("step0");
			if(locatorType.equals("href")){
				 System.out.println("step1");
				List<WebElement> anchors = driver.findElements(By.tagName("a"));
				 System.out.println("step2");
			    Iterator<WebElement> i = anchors.iterator();
			    System.out.println("step3");
			    while(i.hasNext()) {
			        WebElement anchor = i.next();
			        
			        String s1=anchor.getAttribute("href");
			        System.out.println(s1);
			        if(s1.contains(value)) {
			        	System.out.println("Step 5");
				    	System.out.println(value);
				        anchor.click();
				        break;
			        }
			    }
			    return pass;
			}
			else{
				
			
			By locator;
			locator = locatorValue(locatorType, value);
			
			//Wait     
		     WebDriverWait wait1=new WebDriverWait(driver,20);
		     wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));
		     WebElement element = driver.findElement(locator);
			element.click();
			//ExtentTestManager.getTest().log(LogStatus.PASS, result);
			return pass;
			}
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
		}
	}
	
	public String select_Dropdown (String locatorType, String value, String text, String result, String sshot) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			 WebDriverWait wait1=new WebDriverWait(driver,20);
		     wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Select element = new Select(driver.findElement(locator));
	     	element.selectByVisibleText(text);
	     	//ExtentTestManager.getTest().log(LogStatus.PASS, result);
	     	return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
			
		}
	}
	
	public String wait_ForElement (String locatorType, String value, String result, String sshot) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebDriverWait wait1=new WebDriverWait(driver,20);
			// Wait till the element is not visible
			WebElement element=wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));
			//ExtentTestManager.getTest().log(LogStatus.PASS, result);
			return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
			
		}
	}
	
	public String wait_ForTime (String result, String sshot) {
		try {
			Thread.sleep(1000);
			return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
			
		}
	}
	
	
	public String multiple_Select(String locatorType, String value,String multipleVals, String result, String sshot){
		try{
			By locator;
			locator = locatorValue(locatorType, value);
			String multipleSel[] = multipleVals.split(",");

			   for (String valueToBeSelected : multipleSel) {
				   
				   new Select(driver.findElement(locator)).selectByVisibleText(valueToBeSelected);

			   }
		   return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
			
		}
	}
	
	public String accept_Alert(String result, String sshot){
		try{
			driver.switchTo().alert().accept();
			return pass;
		}catch(Exception e){
			System.out.println("from reusable"+e);
			return pass;
			
		}
		
		
	}
	
	
	
	public String switch_To_Frame(String locatorType, String value, String result, String sshot){
		try{
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement frame1=driver.findElement(locator);
		    driver.switchTo().frame(frame1);
	
		    return pass;
		}catch(Exception e){
			System.out.println("from reusable"+e);
			return fail;
			
		}
		
	}
	public String switch_From_Frame(String result, String sshot){
		try{
			driver.switchTo().defaultContent();
	
		    return pass;
		}catch(Exception e){
			System.out.println("from reusable"+e);
			return fail;
			
		}
		
	}
	public String close_Browser(String result, String sshot) {
		try{
			Thread.sleep(600);
		driver.quit();
//		//ExtentTestManager.getTest().log(LogStatus.PASS, result);
		return pass;
		}catch(Exception e){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, result+"failed");
			System.out.println("from reusable"+e);
			return fail;
		}
	}
  
}
