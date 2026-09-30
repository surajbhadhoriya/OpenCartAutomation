package com.utilities.qa.demo;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderMethod {
	
	@DataProvider(name="dp")
	public Object[][] getDataFromExcel() throws IOException{
		String path="C:\\Users\\admin\\eclipse-workspace\\OpenCartAutomation\\testData\\OpenCartTestData.xlsx";
		ExcelUtilities ex = new ExcelUtilities(path);
		
		int rows = ex.getRowCount("Sheet1");
		int col = ex.getCellCount("Sheet1", 1);
		Object[][] data = new Object[rows][col];
		for(int r=0;r<rows; r++) {
			for(int c=0; c<col; c++) {
				data[r][c]= ex.getCellData("Sheet1", r+1, c);
				
			}
			System.out.println("data :"+data);
		}
		
		
		
		return data;
		
	}

}
