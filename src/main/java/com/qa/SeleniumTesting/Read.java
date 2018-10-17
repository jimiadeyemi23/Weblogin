package com.qa.SeleniumTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read 
{
	
	private static XSSFSheet ExcelWSheet;
	
	private static XSSFCell cell;
	
	private static XSSFWorkbook ExcelWBook;
	
	private static XSSFRow row;
	
	
	
	
	public static void setExcelFile(String path, int sheetIndex)
	{
		
		
		try
		{
			Constants con  = new Constants();
			
			//open excel file
			FileInputStream ExcelFile = new FileInputStream(Constants.path);
			
			//access the data sheet
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			
			ExcelWSheet = ExcelWBook.getSheetAt(sheetIndex);
			
			ExcelFile.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static XSSFSheet getExcelWSheet()
	{
		return ExcelWSheet;
		
	}
	
	public static String getCellData(int Rownum, int ColNum) //read
	{
		try
		{
			cell = ExcelWSheet.getRow(Rownum).getCell(ColNum);
			
			String CellData = cell.getStringCellValue();
			
			return CellData;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
			return ""; //if the cell is empty
		}
	}
	
	
	public static void setCellData(String Result, int RowNum, int ColNum) //write
	{
		try
		{
			row = ExcelWSheet.getRow(RowNum);
			
			cell = row.getCell(ColNum);
			
			if(cell == null)
			{
				cell = row.createCell(ColNum);
				
				cell.setCellValue(Result);
			}
			
			else
			{
				cell.setCellValue(Result);
			}
			
			
			FileOutputStream fileOut = new FileOutputStream(Constants.path);
			
			ExcelWBook.write(fileOut);
			
			fileOut.flush();
			
			fileOut.close();
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
}
