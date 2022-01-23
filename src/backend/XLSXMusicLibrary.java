package src.backend;

// Java program to write data in excel sheet using java code

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class XLSXMusicLibrary
{
    private static XSSFWorkbook workbook;
    private static XSSFSheet spreadsheet;
    private static XSSFRow row;
	private static Map<Integer, Object[]> metadata;
	private int index;

    public XLSXMusicLibrary()
    {
        workbook = new XSSFWorkbook();
        spreadsheet = workbook.createSheet("Princess Anne High School Orchestras Music Library");
		metadata = new TreeMap<Integer, Object[]>();
		index = 0;
    }

	public void add(Composition c)
	{
		metadata.put(index, new Object[] {c.getTitle(),
										c.getComposer(),
										c.getArranger(),
										c.getPublisher(),
										c.getVbodaGrade(),
										c.getNotes()});
		index++;
	}

	// any exceptions need to be caught
	public static void write() throws Exception
    {
        Set<Integer> keyid = metadata.keySet();
  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (Integer key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = metadata.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(obj.toString());
            }
        }
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
            new File("C:/Users/Michael Tu/Desktop/Code/IA/Data.xlsx"));
  
        workbook.write(out);
        out.close();
    }
}

