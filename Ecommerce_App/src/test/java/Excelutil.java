import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {

	public static Object[][] getTestData(String File_Path, String Sheet_name) throws IOException
	{
		FileInputStream fis = new FileInputStream(File_Path);
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet=workbook.getSheet(Sheet_name);
		
		int rowcount =  sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] data = new Object[rowcount-1][colcount];
		
		for(int i=1; i<rowcount;i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				Cell cell= row.getCell(j);
				data[i-1][j] = cell.toString();
			}
		}
		workbook.close();
		return data;
		
		
		
	}
}
