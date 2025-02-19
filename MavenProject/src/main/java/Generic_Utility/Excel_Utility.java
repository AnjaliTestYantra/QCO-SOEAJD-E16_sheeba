package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Utility {

	/**
	 * This method is used to read data from ExcelSheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String readDataFromExcelSheet(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		// step1:- path connection
				FileInputStream efis = new FileInputStream("./src/test/resources/testScriptData.xlsx");

				// step2:- keep workbook in read mode
				Workbook wb = WorkbookFactory.create(efis);
				
				String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
                wb.close();
				return data;
	}
	
	/**
	 * This method is used to read data from EXcel Using DataFormatter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		// step1:- path connection
		FileInputStream efis = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(efis);

		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
		
	}
	
	// To Write the data back to excel sheet
	
	public void WriteDataIntoExcelFile(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}