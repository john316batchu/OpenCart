package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	

	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
		
		String path=".\\testdata\\Opencart_LoginData.xlsx";
		ExcelUtility util=new ExcelUtility(path);
		
		int rowCount=util.getRowCount("Sheet1");
		int colCount=util.getCellCount("Sheet1", 1);
		
		String[][] data=new String[rowCount][colCount];
		
		for(int r=1;r<=rowCount;r++) {
			
			for(int c=0;c<colCount;c++) {
				data[r-1][c]=util.getCellData("Sheet1", r, c);
			}
		}
		return data;
	}

}
