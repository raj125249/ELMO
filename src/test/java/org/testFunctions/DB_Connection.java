package org.testFunctions;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.common.BasicFunctions;
import org.testng.annotations.Test;

public class DB_Connection extends BasicFunctions {
	
	@Test
	private void tc_001() throws IOException, ClassNotFoundException {
		
		String get_DB_Data = get_DB_Data("select * from m_insured where rownum<=1", "INS_CODE");
		System.out.println(get_DB_Data);
		List<DBCredentials> dbCredentialsList = new ArrayList<>();
 
	        //Load the Excel file
	        File file = new File(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx");
	        FileInputStream fileInputStream = new FileInputStream(file);
	        Workbook book = new XSSFWorkbook(fileInputStream);
	        Sheet sheet = book.getSheetAt(0); // Assuming the data is in the first sheet
 
	        //Read the data
	        for (Row row : sheet) {
	            Cell flagCell = row.getCell(2); // Assuming the flag is in the second column (index 1)
	            if (flagCell != null && "Y".equalsIgnoreCase(flagCell.getStringCellValue())) {
	                // Assuming URL, username, and password are in 3rd, 4th, and 5th columns respectively
	                String dbUrl = row.getCell(3).getStringCellValue();
	                String dbUser = row.getCell(4).getStringCellValue();
	                String dbPassword = row.getCell(5).getStringCellValue();
	                dbCredentialsList.add(new DBCredentials(dbUrl, dbUser, dbPassword));
	            }
	        }
	        fileInputStream.close();
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        //Connect to each database
	        for (DBCredentials creds : dbCredentialsList) {
	            try (Connection connection = DriverManager.getConnection(creds.getUrl(), creds.getUser(), creds.getPassword())) {
	                System.out.println("Connected to the database successfully: " + creds.getUrl());
	                
	                //Execute the query
	                String query = "select * from m_insured where rownum<=1"; // Your query here
	                try (PreparedStatement prepareStatement = connection.prepareStatement(query);
	                     ResultSet executeQuery = prepareStatement.executeQuery()) {
	                    while (executeQuery.next()) {
	                        String string = executeQuery.getString("INS_NAME");
	                        System.out.println(string);
	                    }
	                }
	            } catch (Exception e) {
	                System.out.println("Connection failed: " + e.getMessage());
	            }
	        }
	    }

		// Helper class to hold DB credentials
	    static class DBCredentials {
	        private String url;
	        private String user;
	        private String password;
 
	        public DBCredentials(String url, String user, String password) {
	            this.url = url;
	            this.user = user;
	            this.password = password;
	        }
 
	        public String getUrl() {
	            return url;
	        }
 
	        public String getUser() {
	            return user;
	        }
 
	        public String getPassword() {
	            return password;
	   }
	}
}
