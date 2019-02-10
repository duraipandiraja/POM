package TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import TestBase.TestBase;



public class TestUtil extends TestBase {
	
	public static String TESTDATA_SHEET_PATH = "./TestData/TestData.xlsx";

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}	
			

	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
     
	
	
	public Object[][] read_excel() throws IOException
	{
		//ReadExcel		
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		 w = new XSSFWorkbook(file);
		 sh = w.getSheet("Sheet1");
		 String[][] data = new String[sh.getPhysicalNumberOfRows()][sh.getRow(0).getPhysicalNumberOfCells()];
		 
		 for(int i=0;i<=sh.getLastRowNum();i++)
		 {
			 for(int j=0;j<sh.getRow(0).getPhysicalNumberOfCells();j++)
				 
			 {
				 data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				 System.out.println(data[i][j]);
			 }
		 }
		 
		
	
      return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	

}
