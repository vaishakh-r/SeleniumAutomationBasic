package com.vt.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "getTestDataExcel")
	public void TestDataExcel(Object[] a) {
		System.out.println("Excel -"+a.toString());
	}
	
	@Test(dataProvider = "getTestDataExcelEfficient")
	public void TestDataExcelEfficient(Map<String, String> map) {
		System.out.println("Efficicent Excel -"+map.toString());
	}

	@Test(dataProvider = "getTestData1")
	public void Test1(String a) {
		System.out.println("Single Dimns "+a);
	}

	@Test(dataProvider = "dummy")
	public void Test2(String a) {
		System.out.println("Run TestData "+a);
	}

	@Test(dataProvider="getTestData3")
	public void Test3(String a, String b, String c) {
		System.out.println("TestData Obj "+a);
	}
	
	@Test(dataProvider="getEmployeeData")
	public void Test4(Employee employee) {
		System.out.println("Employee  "+employee.getId()+ " "+employee.getName());
	}


	@DataProvider
	public String[] getTestData1() {
		String a[] = {"Anc", "BCD", "CDE"};
		return a;
	}

	@DataProvider(name = "dummy")
	public String[] getTestData2() {
		String a[] = {"Anc", "BCD", "CDE"};
		return a;
	}

	@DataProvider
	public Object[][] getTestData3() {
		return new Object[][] {
			{"Abc", "BCD", "CDE"},{"DDD", "FFF", "FGG"}, {"GGG", "JJJ", "KKK"}
		};
	}
	
	@DataProvider(parallel =  true)
	public Employee[] getEmployeeData() {
		return new Employee[] {
				new Employee("ID1", "name1"),
				new Employee("ID2", "name2"),
				new Employee("ID3", "name3"),
				new Employee("ID4", "name4")
		};
	}
	
	
	@DataProvider
	public Object[][] getTestDataExcel() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet =  workbook.getSheet("userlist");
		
		int rowNum = sheet.getLastRowNum();
		int colNum = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowNum][colNum];
		
		for (int i=1; i <= rowNum; i++) {
			for (int j=0; j < colNum; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
		}
		}
		return data;
	}
	
	
	@DataProvider
	public Object[] getTestDataExcelEfficient() throws IOException {

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet =  workbook.getSheet("userlist");

		int rowNum = sheet.getLastRowNum(); // ROW NUM - STARTS FROM 1 
		int colNum = sheet.getRow(0).getLastCellNum();

		Object[] data = new Object[rowNum];
		Map<String, String> map;

		for (int i=1; i <= rowNum; i++) {
			map = new HashMap<>();
			for (int j=0; j < colNum; j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			data[i-1] = map;
		}
		return data;
	}

}

 
class Employee{
	
	String id; 
	String name;
	
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
