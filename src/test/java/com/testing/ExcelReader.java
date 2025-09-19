package com.testing;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] getExcelData(String filePath, String sheetName) {
		Object[][] data = null;
		try (FileInputStream file = new FileInputStream(filePath); Workbook workBook = new XSSFWorkbook(file)) {
			Sheet sheet = workBook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum();
			int totalCols = sheet.getRow(0).getLastCellNum();
			data = new Object[totalRows][totalCols];
			for (int i = 1; i < totalRows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < totalCols; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = (cell == null) ? "" : cell.toString();
				}
			}
		} catch (Exception e) {
			
		}
		return data;
	}
}