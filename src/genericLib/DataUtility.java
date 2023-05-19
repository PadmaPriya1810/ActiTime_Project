package genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility
{
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\testdata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);	
		String value=pobj.getProperty(key);
		return value; 
	}
	
	public String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Customer Assignment.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheet);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(row).getCell(cell));
		return value;
	}
	
	public void putDataIntoExcel(String sheetname,int rownum,int cellnum,String cellvalue) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("C:\\Users\\Priya\\Documents\\Selenium\\Write Data.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	
	sh.createRow(rownum).createCell(cellnum).setCellValue(cellvalue);
	
	//TO WRITE THE DATA INTO THE FILE
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Priya\\Documents\\Selenium\\Write Data.xlsx");
	
	//TO WRITE THE VALUE IN EXCEL WORKBOOK
	book.write(fos);
	fos.flush();//Compulsory Method
	}

}
