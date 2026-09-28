package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import org.openqa.selenium.devtools.idealized.Network.UserAgent;


public class DataProviders {
	
	@DataProvider(name="login_data")
	public String[][] dataProvider() throws IOException {
		String path=System.getProperty("user.dir")+"\\testdatas\\test_data.xlsx";
		excelUtilities exu=new excelUtilities(path);
		int last_row=exu.read_row(0);
		int last_cell=exu.read_cell(0, 0);
		
		String [][]obj= new String[last_row][last_cell];
		for(int i=0;i<last_row;i++) {
			for(int j=0;j<last_cell;j++) {
				obj[i][j]=exu.read_data(0, i, j);
				System.out.println(obj[i][j]);
			}
		}
		return obj;
	}

}
