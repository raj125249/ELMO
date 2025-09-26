package org.common;

public class ReadData {

	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
//		int rowCount = excel.getRowCount();
//		int colCount = excel.getcolCount();
//		Object data[][] = new Object[rowCount - 1][colCount];
//		for (int i = 1; i < rowCount; i++) {
//			for (int j = 0; j < colCount; j++) {
//				String getData = excel.getCellDataString(i, j);
//				data[i - 1][j] = getData;
//			}
//		}
//		return data;
//	}

		int rowCount = excel.getRowCount();
		int colCount = excel.getcolCount();
		Object data[][] = new Object[rowCount - 1][colCount];
		int validRowCount = 0;
		int flagColumnIndex = colCount - 1;

		for (int i = 1; i < rowCount; i++) {
			String flagName = excel.getCellDataString(i, flagColumnIndex);
			if (flagName.equalsIgnoreCase("Y")) {
				for (int j = 0; j < colCount; j++) {
					String getData = excel.getCellDataString(i, j);
					data[validRowCount][j] = getData;
				}
				validRowCount++;
			}
		}

		Object trimmedData[][] = new Object[validRowCount][colCount];
		for (int i = 0; i < validRowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				trimmedData[i][j] = data[i][j];
			}
		}

		return trimmedData;
	}
}
