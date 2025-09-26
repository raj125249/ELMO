package org.common;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String readExcel(String sheetname, int rowno, int cellno) throws IOException {
		String data = null;
		File file = new File(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		if (type == 1) {
			data = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			data = dateFormat.format(dateCellValue);
		}

		else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			data = String.valueOf(l);

		}
		return data;

	}

	public static String getDoubleValue(String sheetname, int rowno, int cellno) throws IOException {
		String data = null;
		File file = new File(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		double d = cell.getNumericCellValue();
//		float f = (float) d;
		data = String.valueOf(d);
		return data;
	}

}
