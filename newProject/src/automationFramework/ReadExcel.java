package automationFramework;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Locale;


    public class ReadExcel {
                private static HSSFSheet ExcelWSheet;
                private static HSSFWorkbook ExcelWBook;
                private static HSSFCell Cell;
 
            //This method is to set the File path and to open the Excel file
            //Pass Excel Path and SheetName as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
	                FileInputStream ExcelFile = new FileInputStream(Path);
	                ExcelWBook = new HSSFWorkbook(ExcelFile);
	                ExcelWSheet = ExcelWBook.getSheet(SheetName);
	                
                   }
 
            //This method is to read the test data from the Excel cell
            //In this we are passing parameters/arguments as Row Num and Col Num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
            	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            	  DataFormatter formatter = new DataFormatter(Locale.US);
            	  try{
                  String CellData = Cell.getStringCellValue();
                  return CellData;
            	  }catch(Exception e){
            		  String cellvalue = "" + Cell.getNumericCellValue();
            		  String CellData = formatter.formatCellValue(Cell);
            		  return CellData;
            	  }
            	  
            	}
            public static int getRowCount() {
        		return ExcelWSheet.getPhysicalNumberOfRows();
        	}

        	public static int getColumnCount() {
        		return 5;
        		
        	}
    	}