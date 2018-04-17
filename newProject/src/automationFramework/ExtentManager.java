package automationFramework;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	static ExtentReports extent;
	
    final static String filePath = "C:\\Users\\Jayesh\\Desktop\\TestCases\\Extent.html";
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
        }
        
        return extent;
    }
}
