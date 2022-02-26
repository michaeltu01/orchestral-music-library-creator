package src.backend;

import java.util.ArrayList;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private static File database;

    //Constructor
    public Library(File file)
    {
        database = file;
        metadata = new ArrayList<Composition>();

        if(!database.exists()) // Checks if the file exists
        {
            XSSFWorkbook newXLSX = new XSSFWorkbook();
            XSSFSheet newSheet = newXLSX.createSheet();
            newSheet.createRow(0);
            FileOutputStream fileOut;
            try {
                fileOut = new FileOutputStream(database);
                try {
                    newXLSX.write(fileOut);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("New Database.xlsx file has been created successfully.");  
                try {
                    newXLSX.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }            
        }
        read(database);
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

    public String getFilePath() throws IOException
    {
        return database.getCanonicalPath();
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

    public ArrayList<Composition> mergeSortByTitle()
    {
        return mergeSort(metadata, 0, metadata.size()-1, true);
    }

    public ArrayList<Composition> sortByVbodaGrade()
    {
        return mergeSort(metadata, 0, metadata.size()-1, false);
    }

    //https://www.geeksforgeeks.org/merge-sort/ 
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void mergeByGrade(ArrayList<Composition> arr, int l, int m, int r)
    {       
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<Composition> left = new ArrayList<Composition>(n1);
        ArrayList<Composition> right = new ArrayList<Composition>(n2);

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            left.add(arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            right.add(arr.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (left.get(i).getVbodaGrade() < right.get(j).getVbodaGrade()) {
                arr.add(k, left.get(i));
                i++;
            }
            else if(left.get(i).getVbodaGrade() == right.get(j).getVbodaGrade())
            {
                if(left.get(i).getTitle().compareTo(right.get(j).getTitle()) <= 0)
                {
                    arr.add(k, left.get(i));
                    i++;
                }
                else
                {
                    arr.add(k, right.get(j));
                    j++;
                }
            }
            else {
                arr.add(k, right.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.add(k, left.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.add(k, right.get(j));
            j++;
            k++;
        }
    }

    public static void mergeByTitle(ArrayList<Composition> arr, int l, int m, int r)
    {        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<Composition> left = new ArrayList<Composition>(n1);
        ArrayList<Composition> right = new ArrayList<Composition>(n2);

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            left.add(arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            right.add(arr.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (left.get(i).getTitle().compareTo(right.get(j).getTitle()) < 0) {
                arr.add(k, left.get(i));
                i++;
            }
            else {
                arr.add(k, right.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.add(k, left.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.add(k, right.get(j));
            j++;
            k++;
        }
    }
    
    // Main function that sorts arr[l..r] using
    // merge()
    public static ArrayList<Composition> mergeSort(ArrayList<Composition> arr, int l, int r, boolean ifSortTitle)
    {
        if (l < r)
        {
            // Find the middle point
            int m = l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m, ifSortTitle);
            mergeSort(arr, m + 1, r, ifSortTitle);

            // Merge the sorted halves
            if(ifSortTitle)
            {
                mergeByTitle(arr, l, m, r);
            }
            else
            {
                mergeByGrade(arr, l, m, r);
            }
        }
        return arr;
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
