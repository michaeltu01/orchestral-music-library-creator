package src.backend;

import java.util.ArrayList;
import java.io.File;  
import java.io.FileInputStream;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// // See if you can optimize code by simply creating a new Library object
public class VBODALibrary
{
    //ArrayList variable
    private static ArrayList<Composition> vbodaLibrary;

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static final File F = new File("VBODA Music Library.xlsx"); // Put the VBODA Music Library into a zip folder

    //Constructor
    public VBODALibrary()
    {
        vbodaLibrary = new ArrayList<Composition>();
        read(F);
    }

    //Getters
    public Composition getComposition(int index)
    {
        return vbodaLibrary.get(index);
    }

    public int getIndex(Composition c)
    {
        return vbodaLibrary.indexOf(c);
    }

    public ArrayList<Composition> getAll()
    {
        return vbodaLibrary;
    }

    public int size()
    {
        return vbodaLibrary.size();
    }

    //Setters
    public void append(Composition c)
    {
        vbodaLibrary.add(c);
    }

    public void add(Composition c, int index)
    {
        vbodaLibrary.add(index, c);
    }

    public Composition remove(int index)
    {
        return vbodaLibrary.remove(index);
    }

    public Composition remove(Composition c)
    {
        return vbodaLibrary.remove(this.getIndex(c));
    }

    public Composition replace(int index, Composition c)
    {
        return vbodaLibrary.set(index, c);
    }

    public void clear()
    {
        vbodaLibrary.clear();
    }

    //Instance Methods
    public ArrayList<Composition> sortByTitle() //Returns vbodaLibrary sort alphabetically by title ascending (A-Z)
    {
        for (int j = 0; j < vbodaLibrary.size(); j++)
        {
            Composition curr = vbodaLibrary.get(j);
            String currtitle = curr.getTitle();
            int i = j-1;
            while ((i > -1) && (vbodaLibrary.get(i).getTitle().compareTo(currtitle) > 0))
            {
                this.replace(i+1, this.getComposition(i));
                i--;
            }
            this.replace(i+1, curr);
        }

        return vbodaLibrary;
    }

    public static void read(File xlsx)
    {
        ArrayList<Composition> compositions = new ArrayList<Composition>();
        try
        {
            FileInputStream fis = new FileInputStream(xlsx); // Obtaining bytes from the file  
            wb = new XSSFWorkbook(fis); // Creating Workbook instance that refers to .xlsx file
            sheet = wb.getSheetAt(0); // Creating a Sheet object to retrieve object

            Iterator<Row> itr = sheet.iterator(); // Iterating over Excel file

            while (itr.hasNext())                 
            {  
                Row row = itr.next(); 
                ArrayList<String> arr = new ArrayList<String>(); //Individual composition vbodaLibrary
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
                        case STRING: // Field that represents string cell type  
                            arr.add(cell.getStringCellValue());  
                            break;
                        case NUMERIC: // Field that represents number cell type  
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
            vbodaLibrary = compositions;
        }

        catch(Exception e)  
        {  
            e.printStackTrace();  
        }
    }  

    //toString
    public String toString()
    {
        String temp = "";

        for(int i = 0; i < vbodaLibrary.size(); i++)
        {
            temp = temp + i + ": " + vbodaLibrary.get(i).toString() + "\n";
        }

        return temp;
    }
}
