package com.utilities.qa.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public XSSFWorkbook workbook;
	public FileInputStream  fi;
	public FileOutputStream fo;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String path;
	public CellStyle style;
	
	public ExcelUtilities(String path) {
		this.path = path;
	}
	
	
	
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rows;
		
	}
	
	public int getCellCount(String sheetName, int row) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int cells = sheet.getRow(row).getLastCellNum();
		workbook.close();
		fi.close();
		return cells;
		
	}
	
	
	public String getCellData(String sheetName, int r, int c) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(r);
		cell = row.getCell(c);
		String cellData = cell.toString();
		workbook.close();
		fi.close();
		return cellData;
		
	}
	
	public void setcellData(String sheetName, int r, int c, String data) throws IOException {
		File xlfile = new File(path);
		if(!xlfile.exists()) {
			fo = new FileOutputStream(path);
			workbook = new XSSFWorkbook();
			workbook.write(fo);
		}
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1) {
			workbook.createSheet(sheetName);
		}
		sheet= workbook.getSheet(sheetName);
		
		if(sheet.getRow(r)==null) {
			sheet.createRow(r);
			
		}
		row = sheet.getRow(r);
		
		cell=row.createCell(c);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	public void fillGreenColor(String sheetName, int r, int c) throws IOException {
		fi = new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row = sheet.getRow(r);
		 cell = row.getCell(c);
		 style = workbook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 cell.setCellStyle(style);
		 workbook.write(fo);
		 workbook.close();
		 fi.close();
		 fo.close();
	}
	
	public void fillRedColor(String sheetName, int r, int c) throws IOException {
		fi = new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row = sheet.getRow(r);
		 cell = row.getCell(c);
		 style = workbook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.RED.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 cell.setCellStyle(style);
		 workbook.write(fo);
		 workbook.close();
		 fi.close();
		 fo.close();
	}
	
	

}
