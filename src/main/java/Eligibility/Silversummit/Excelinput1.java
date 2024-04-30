package Eligibility.Silversummit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excelinput1 {

	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\PonkumarE\\Documents\\Test\\Excelinput.xlsx");
	  	 FileInputStream fis=new FileInputStream(f);
	  	 XSSFWorkbook xsf=new XSSFWorkbook(fis);
	  	 XSSFSheet sheet= xsf.getSheetAt(0);
	  	 DataFormatter formatter = new DataFormatter();
	  	String outputFilePath = "C:\\Users\\PonkumarE\\Documents\\Test\\output.xlsx"; 
  		Workbook workbook = new XSSFWorkbook();
  		 Sheet sheet1= workbook.createSheet("Sheet1");
	  	 for(int i=1;i<=sheet.getLastRowNum();i++)
	  	 {
	  		 String number=formatter.formatCellValue(sheet.getRow(i).getCell(0));
	  		 String fnumber="";
	  		if(number.length()==3)
	  		{
	  			fnumber="0"+number;
	  		}
	  		if(number.length()==2)
	  		{
	  			fnumber="00"+number;
	  		}
	  		if(number.length()==1)
	  		{
	  			fnumber="000"+number;
	  		}
	  		
	  		 Row row = sheet.createRow(i);
	  		 Cell cell = row.createCell(0, CellType.STRING);
	  		 cell.setCellValue(fnumber);
	  		
            
	}
	  	FileOutputStream fileOut = new FileOutputStream(outputFilePath);
  		workbook.write(fileOut);
	}

}
