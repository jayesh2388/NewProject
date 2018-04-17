package automationFramework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.Calendar;

public class myMethods {

	
	//date method
	public static String getDate( ){
		Format formatter = new SimpleDateFormat("MMM"); 
	    String mon = formatter.format(new Date());
	    Format formatterd = new SimpleDateFormat("dd");
	    String s = formatterd.format(new Date());
	    String dum="";
	    if (s.matches("01")) 
	    	dum=mon+"One";
	    else
	    	if (s.matches("02")) 
	    		dum=mon+"Two";
	    	else 
	    		if (s.matches("03"))
	    			dum=mon+"Three";
	    		else
	    			if (s.matches("04"))
		    			dum=mon+"Four";
	    			else
		    			if (s.matches("05"))
			    			dum=mon+"Five";
		    			else
			    			if (s.matches("06"))
				    			dum=mon+"Six";
			    			else
				    			if (s.matches("07"))
					    			dum=mon+"Seven";	
				    			else
					    			if (s.matches("08"))
						    			dum=mon+"Eight";
					    			else
						    			if (s.matches("09"))
							    			dum=mon+"Nine";
						    			else
							    			if (s.matches("10"))
								    			dum=mon+"Ten";
							    			else
								    			if (s.matches("11"))
									    			dum=mon+"Ten";
								    			else
									    			if (s.matches("12"))
										    			dum=mon+"Twelve";
									    			else
										    			if (s.matches("13"))
											    			dum=mon+"Thirteen";
										    			else
											    			if (s.matches("14"))
												    			dum=mon+"Forteen";
											    			else
												    			if (s.matches("15"))
													    			dum=mon+"Fifteen";
												    			else
													    			if (s.matches("16"))
														    			dum=mon+"Sixteen";
													    			else
														    			if (s.matches("17"))
															    			dum=mon+"Seventeen";
														    			else
															    			if (s.matches("18"))
																    			dum=mon+"Eighteen";
															    			else
																    			if (s.matches("19"))
																	    			dum=mon+"Nineteen";
																    			else
																	    			if (s.matches("20"))
																		    			dum=mon+"Twenteen";
																	    			else
																		    			if (s.matches("21"))
																			    			dum=mon+"TwentyOne";
																		    			else
																			    			if (s.matches("22"))
																				    			dum=mon+"TwentyTwo";	    
																			    			else
																				    			if (s.matches("23"))
																					    			dum=mon+"TwentyThree";
																				    			else
																					    			if (s.matches("24"))
																						    			dum=mon+"TwentyFour";
																					    			else
																						    			if (s.matches("25"))
																							    			dum=mon+"TwentyFive";
																						    			else
																							    			if (s.matches("26"))
																								    			dum=mon+"TwentySix";
																							    			else
																								    			if (s.matches("27"))
																									    			dum=mon+"TwentySeven";
																								    			else
																									    			if (s.matches("28"))
																										    			dum=mon+"TwentyEight";
																									    			else
																										    			if (s.matches("29"))
																											    			dum=mon+"TwentyNine";
																										    			else
																											    			if (s.matches("30"))
																												    			dum=mon+"Thirty";
																											    			else
																												    			if (s.matches("31"))
																													    			dum=mon+"ThirtyOne";
	    	    
	//    System.out.println(dum);
	    return dum;
	}
	
public static String currDate( ){
// Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//get current date time with Date()
        Date date = new Date();
//Now format the date
        String date1= dateFormat.format(date);
		return date1;
		
	}

public static String calcDate(int a){
	
	            
    SimpleDateFormat formattedDate = new SimpleDateFormat("M/d/yyyy");            
    Calendar c = Calendar.getInstance();        
    c.add(Calendar.DATE,a);  // number of days to add      
    String retDate = (formattedDate.format(c.getTime()));

    return retDate;
    
		}


}
