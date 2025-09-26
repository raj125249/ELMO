package org.common;

import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			projectPath = System.getProperty("user.dir");
			workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return rowCount;

	}

	public static int getcolCount() {
		int colCount = 0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return colCount;

	}

	public static String getCellDataString(int rownum, int colnum) {
		String cellData = null;
		try {
//			cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			XSSFCell cell =sheet.getRow(rownum).getCell(colnum);
			DataFormatter df = new DataFormatter();
			cellData = df.formatCellValue(cell);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return cellData;
	}

}
