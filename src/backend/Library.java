package src.backend;
import src.backend.MergeSort;

import java.util.ArrayList;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Library extends ArrayList
{
    //ArrayList variable
    private static ArrayList<Composition> metadata;

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static final File f = new File("C:/Users/Michael Tu/Desktop/Code/IA/Data.xlsx");

    //Constructor
    public Library()
    {
        metadata = new ArrayList<Composition>();

        if(!f.exists())
        {
            try 
            { 
            FileOutputStream fileOut = new FileOutputStream("C:/Users/Michael Tu/Desktop/Code/IA/Data.xlsx");  //BUG: File created with no bytes
            fileOut.close();  
            } 
            catch (Exception e) 
            {  
            e.printStackTrace();  
            }  
        }

        try
        {
            // Copied from https://www.javatpoint.com/how-to-read-excel-file-in-java
            FileInputStream fis = new FileInputStream(f);   //obtaining bytes from the file  
            wb = new XSSFWorkbook(fis); //creating Workbook instance that refers to .xlsx file
            sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  

            Iterator<Row> itr = sheet.iterator();    //iterating over excel file

            while (itr.hasNext())                 
            {  
                Row row = itr.next();  
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                ArrayList<String> arr = new ArrayList<String>();    //individiual composition metadata

                while (cellIterator.hasNext())   
                {  
                    Cell cell = cellIterator.next();  
                    switch (cell.getCellType())               
                    {  
                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                            arr.add(cell.getStringCellValue());  
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                            arr.add(String.valueOf(cell.getNumericCellValue()));  
                            break;
                        default:
                            System.out.println("This is the default operation"); 
                    }  
                }
                Composition c = new Composition(arr);
                metadata.add(c);
            }
        }

        catch(Exception e)  
        {  
            e.printStackTrace();  
        }
    }

    //Getters
    public Composition getComposition(int index)
    {
        return metadata.get(index);
    }

    public int getIndex(Composition c)
    {
        return metadata.indexOf(c);
    }

    public int size()
    {
        return metadata.size();
    }

    //Setters
    public void append(Composition c)
    {
        metadata.add(c);
    }

    public void add(Composition c, int index)
    {
        metadata.add(index, c);
    }

    //Instance Methods
    public ArrayList<Composition> sortByTitle() //Returns metadata sort alphabetically by title ascending (A-Z)
    {
        for (int j = 1; j < metadata.size(); j++)
        {
            String current = metadata.get(j).getTitle();
            int i = j-1;
            while ((i > -1) && (metadata.get(i).getTitle().compareTo(current) > 0))
            {
                metadata.get(i+1).setTitle(metadata.get(i).getTitle());
                i--;
            }
            metadata.get(i+1).setTitle(current);
        }

        return metadata;
    }

    public static void write(File xlsx) throws Exception
    {
        File file = xlsx;
        int rowid = 0;
  
        // writing the data into the sheets...
        System.out.println("Metadata list size: " + metadata.size());
        for (int i = 0; i < metadata.size(); i++) 
        {
            XSSFRow row = sheet.createRow(rowid++);
            Composition c = metadata.get(i);
            ArrayList<String> arr = c.toArrayList();
            int cellid = 0;
  
            for (int j = 0; j < 6; j++) // j == num of instance variables in a Composition
            {
                Cell cell = row.createCell(j);
                // if(arr.get(j).getClass().getSimpleName().equals("Integer"))
                // {
                //     CellStyle intStyle = wb.createCellStyle();
                //     DataFormat format = wb.createDataFormat();

                //     intStyle.setDataFormat(format.getFormat("0"));
                //     cell.setCellStyle(intStyle);
                //     cell.setCellValue(arr.get(j));
                // }
                // else
                // {
                //     cell.setCellValue(arr.get(j));
                // }
                cell.setCellValue(arr.get(j));
            }
        }
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(file);
  
        wb.write(out);
        out.close();
    }

    //toString
    public String toString()
    {
        String temp = "";

        for(int i = 0; i < metadata.size(); i++)
        {
            temp = temp + i + ": " + metadata.get(i).toString() + "\n";
        }

        return temp;
    }
}
