package src.backend;
import src.backend.Library;

// Java program to write data in excel sheet using java code

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class XLSXDatabase
{
    private static XSSFWorkbook workbook;
    private static XSSFSheet spreadsheet;
    private static XSSFRow row;
	private static Library metadata;
    private static final File f = new File("C:/Users/Michael Tu/Desktop/Code/IA/Data.xlsx");

    public XLSXDatabase() throws InvalidFormatException, IOException
    {
        FileInputStream fis = new FileInputStream(f);
        workbook = new XSSFWorkbook(fis);

        spreadsheet = workbook.getSheet("PAHS Orchestras Music Library");
		metadata = new Library();
    }

	public void add(Composition c)
	{
		metadata.append(c);
	}

	// any exceptions need to be caught
	public static void write() throws Exception
    {  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (int i = 0; i < metadata.size(); i++) {
  
            row = spreadsheet.createRow(rowid++);
            Composition c = metadata.getComposition(i);
            ArrayList<String> arr = c.toArray();
            int cellid = 0;
  
            for (int j = 0; j < 6; j++) // j == num of instance variables in a Composition
            {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(arr.get(j));
            }
        }
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(f);
  
        workbook.write(out);
        out.close();
    }

    public String toString()
    {
        return metadata.toString();
    }
}

