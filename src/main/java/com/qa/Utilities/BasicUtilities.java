package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.Base;

public class BasicUtilities extends Base{

	public static String FRAME_NAME = "mainpanel";
	public static XSSFWorkbook xssfWorkbook = null;
	public static XSSFSheet sheet = null;
	public static String FILE_PATH = "/Users/vipan/eclipse-workspace/com.qa.FreeCRMDesignOne2021/src/main/"
			+ "java/com/qa/testdatafiles/FreeCRMTestDataExcelSheet.xlsx";
	public static FileInputStream ip = null;
	
	public BasicUtilities() throws Exception {
		//super();
	}

	public static int PAGE_LOAD_TIME_OUT = 30;
	public static int IMPLICIT_TIME_OUT = 20;
	public static int EXPLICIT_TIME_OUT = 20;
	
	public static void switchToFrame() {
		driver.switchTo().frame(FRAME_NAME);
	}
	
	public static void doWaitForElement(By abc) {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) abc));
	}
	
	public static void doSelect(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public static Object[][] fetchData(String sheetName) throws Exception {
		ip = new FileInputStream(FILE_PATH);
		xssfWorkbook = new XSSFWorkbook(ip);
		sheet = xssfWorkbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
