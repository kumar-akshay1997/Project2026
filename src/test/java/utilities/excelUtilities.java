package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelUtilities {
	public  XSSFWorkbook wbook;
	public  XSSFSheet wsheet;
	public  XSSFRow wrow;
	public  XSSFCell wcell;
	//public static FileOutputStream wfo;
	public  FileInputStream wfi;
	String path;
	public excelUtilities(String path) {
		this.path=path;
	}
	
	public int read_row( int rrwsheet) throws IOException {
		wfi = new FileInputStream(path);
		wbook = new XSSFWorkbook(wfi);
		wsheet = wbook.getSheetAt(rrwsheet);
		int rrnum = wsheet.getLastRowNum();
		wbook.close();
		wfi.close();
		return rrnum;
	}
	
	public  int read_cell( int rcwsheet, int i) throws IOException {
		wfi = new FileInputStream(path);
		wbook = new XSSFWorkbook(wfi);
		wsheet = wbook.getSheetAt(rcwsheet);
		wrow = wsheet.getRow(i);
		int rcnum = wrow.getLastCellNum();
		wbook.close();
		wfi.close();
		return rcnum;

	}

	public  String read_data(int rdwsheet, int i, int j) throws IOException {
		wfi = new FileInputStream(path);
		wbook = new XSSFWorkbook(wfi);
		wsheet = wbook.getSheetAt(rdwsheet);
		wrow = wsheet.getRow(i);
		wcell = wrow.getCell(j);
		String rddata;
		try {
			DataFormatter df = new DataFormatter();
			rddata = df.formatCellValue(wcell);
		} catch (Exception e) {
			// TODO: handle exception
			rddata = " ";
		}
		wbook.close();
		wfi.close();
		return rddata;

	}

	
}
