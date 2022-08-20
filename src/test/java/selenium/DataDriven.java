package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	
	public ArrayList<String> getData(String Testname) throws IOException{
		ArrayList<String> a = new ArrayList<String>();
		
		
		FileInputStream fi=new FileInputStream("D:\\Updated Career\\Project and Others\\Career\\Selenium Course\\Sample Tests\\0625A500.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		//Workbook workbook = WorkbookFactory.create(fi);
		
		XSSFSheet sheet = workbook.getSheet("Firstsheet");
		System.out.println(sheet.getLastRowNum());
		Iterator<Row> ir = sheet.iterator();
	
		//below code is to find the column number where the test cases are present.
		while(ir.hasNext())
		{
			Row r = ir.next();
			Iterator<Cell> ic = r.iterator();
			while(ic.hasNext()) {
				
				Cell c = ic.next();
				if(c.getCellType()==CellType.STRING) {
					if(c.getStringCellValue().equalsIgnoreCase(Testname)) {
						
						while(ic.hasNext()) {
						Cell c2 = ic.next();
						if(c2.getCellType()==CellType.STRING) {
						a.add(c2.getStringCellValue());
						}
						else {
							a.add(NumberToTextConverter.toText(c2.getNumericCellValue()));
						}
						
					} break;
						}}
				else {
					if(NumberToTextConverter.toText(c.getNumericCellValue()).equalsIgnoreCase(Testname)) {
											
					while(ic.hasNext()) {
						Cell c2 = ic.next();
						if(c2.getCellType()==CellType.STRING) {
						a.add(c2.getStringCellValue());
						}
						else {
							a.add(NumberToTextConverter.toText(c2.getNumericCellValue()));
						}
						
					} break;		
				}
			}
		
			
		}
		}
		
	
		return a;

	}}	
		
		
	

	


