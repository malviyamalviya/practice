package com.MyHMS.Utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static XSSFWorkbook w;
	public static XSSFSheet s;
	public static XSSFRow r;
	public static XSSFCell c;
	public static FileInputStream fi;
	
	public static String getcellvalue(String filename,String sheetname,int rowno,int cellno) throws IOException {
		fi=new FileInputStream(filename);
		w=new XSSFWorkbook(fi);
		s=w.getSheet(sheetname);
		c=s.getRow(rowno).getCell(cellno);
		w.close();
		return c.getStringCellValue();
	}
	
	public static int getrowcount(String filename,String sheetname) throws IOException {
		fi=new FileInputStream(filename);
		w=new XSSFWorkbook(fi);
		s=w.getSheet(sheetname);
		//get total number of rows
		int rowcount=s.getLastRowNum()+1;
		w.close();
		return rowcount;
		
	}
	
	public static int getcellcount(String filename,String sheetname) throws IOException {
		fi=new FileInputStream(filename);
		w=new XSSFWorkbook(fi);
		s=w.getSheet(sheetname);
		//get total number of rows
		int cellcount=s.getRow(0).getLastCellNum();
		w.close();
		return cellcount;
		
	}
	
}
