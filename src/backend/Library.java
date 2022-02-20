package src.backend;

import java.util.ArrayList;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Library
{
    //ArrayList variable
    private static ArrayList<Composition> metadata;

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;

    //Constructor
    public Library(File file)
    {
        metadata = new ArrayList<Composition>();
        read(file);

        // if(!f.exists()) // Checks if the file exists
        // {
        //     try 
        //     { 
        //     FileOutputStream fileOut = new FileOutputStream("C:/Users/Michael Tu/Desktop/Code/IA/Database.xlsx");  //BUG: File created with no bytes
        //     fileOut.close();  
        //     } 
        //     catch (Exception e) 
        //     {  
        //     e.printStackTrace();  
        //     }  
        // }
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

    public ArrayList<Composition> getAll()
    {
        return metadata;
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

    public Composition remove(int index)
    {
        return metadata.remove(index);
    }

    public Composition remove(Composition c)
    {
        return metadata.remove(this.getIndex(c));
    }

    public Composition replace(int index, Composition c)
    {
        return metadata.set(index, c);
    }

    public void clear()
    {
        metadata.clear();
    }

    //Instance Methods
    public ArrayList<Composition> sortByTitle() //Returns metadata sort alphabetically by title ascending (A-Z)
    {
        for (int j = 0; j < metadata.size(); j++)
        {
            Composition curr = metadata.get(j);
            String currtitle = curr.getTitle();
            int i = j-1;
            while ((i > -1) && (metadata.get(i).getTitle().compareTo(currtitle) > 0))
            {
                this.replace(i+1, this.getComposition(i));
                i--;
            }
            this.replace(i+1, curr);
        }

        return metadata;
    }

    public ArrayList<Composition> sortByVbodaGrade()
    {
        // return metadata;
    }

    public static void read(File xlsx)
    {
        ArrayList<Composition> compositions = new ArrayList<Composition>();
        try
        {
            // Copied from https://www.javatpoint.com/how-to-read-excel-file-in-java
            FileInputStream fis = new FileInputStream(xlsx);   //obtaining bytes from the file  
            wb = new XSSFWorkbook(fis); //creating Workbook instance that refers to .xlsx file
            sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  

            Iterator<Row> itr = sheet.iterator();    //iterating over excel file

            while (itr.hasNext())                 
            {  
                Row row = itr.next(); 
                ArrayList<String> arr = new ArrayList<String>();    //individiual composition metadata
                int rowLength = row.getPhysicalNumberOfCells();

                // while (cellIterator.hasNext())
                // System.out.println("getPhysicalNumberOfCells(): " + rowLength);
                if(rowLength < 6)
                {
                    for(int i = rowLength; i < 6; i++)
                    {
                        row.createCell(i);
                        // System.out.println("Physical number of cells: " + row.getPhysicalNumberOfCells());
                    }
                }

                for(int i = 0; i < 6; i++)  
                {  
                    Cell cell = row.getCell(i);

                    switch (cell.getCellTypeEnum())               
                    {  
                        case STRING:    //field that represents string cell type  
                            arr.add(cell.getStringCellValue());  
                            break;
                        case NUMERIC:    //field that represents number cell type  
                            arr.add(String.valueOf((int)cell.getNumericCellValue()));  
                            break;
                        case BLANK:
                            arr.add(null);
                            break;
                        default:
                            System.out.println("This is the default operation");
                            System.out.println("This is the cell's type: " + cell.getCellTypeEnum());
                    }
                    // System.out.println(arr);
                }
                Composition c = new Composition(arr);
                if(c.isEmpty())
                {
                    continue;
                }
                else
                {
                    compositions.add(c);
                }
            }
            metadata = compositions;
        }

        catch(Exception e)  
        {  
            e.printStackTrace();  
        }
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
            ArrayList<String> arr = c.toStringArrayList();
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
