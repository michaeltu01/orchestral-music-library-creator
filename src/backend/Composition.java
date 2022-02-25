package src.backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Composition
{
    //Instance variables
    private String title;
    private String composer;
    private String arranger;
    private String publisher;
    private Integer vbodaGrade;
    private String notes;

    //Constructors; make more constructors later
    public Composition()
    {
        title = "";
        composer = "";
        arranger = "";
        publisher = "";
        vbodaGrade = 0;
        notes = "";
    }

    public Composition(String title, String composer, String publisher)
    {
        this.title = title;
        this.composer = composer;
        arranger = "";
        this.publisher = publisher;
        vbodaGrade = 0;
        notes = "";
    }

    public Composition(String title, String composer, String publisher, Integer vbodaGrade, String notes)
    {
        this.title = title;
        this.composer = composer;
        arranger = "";
        this.publisher = publisher;
        this.vbodaGrade = vbodaGrade;
        this.notes = notes;
    }

    public Composition(String title, String composer, String arranger, String publisher, Integer vbodaGrade, String notes)
    {
        this.title = title;
        this.composer = composer;
        this.arranger = arranger;
        this.publisher = publisher;
        this.vbodaGrade = vbodaGrade;
        this.notes = notes;
    }

    public Composition(ArrayList<String> arr)
    {
        title = arr.get(0);
        composer = arr.get(1);
        arranger = arr.get(2);
        publisher = arr.get(3);

        if(arr.get(4) == null || arr.get(4) == "")

        {
            vbodaGrade = 0;
        }
        else
        {
            vbodaGrade = Integer.parseInt(arr.get(4));
        }

        notes = arr.get(5);
    }

    //Getters
    public String getTitle()
    {
        return title;
    }

    public String getComposer()
    {
        return composer;
    }

    public String getArranger()
    {
        return arranger;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public Integer getVbodaGrade()
    {
        return vbodaGrade;
    }

    public String getNotes()
    {
        return notes;
    }

    //Setters
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setComposer(String composer)
    {
        this.composer = composer;
    }

    public void setArranger(String arranger)
    {
        this.arranger = arranger;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public void setVbodaGrade(Integer vbodaGrade)
    {
        this.vbodaGrade = vbodaGrade;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    //Instance methods

    public boolean isEmpty()
    {
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(null, null, null, null, "0", null));

        if(this.toStringArrayList().equals(arr))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ArrayList<String> toStringArrayList()
    {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add(title);
        arr.add(composer);
        arr.add(arranger);
        arr.add(publisher);
        arr.add(vbodaGrade.toString());
        arr.add(notes);

        // System.out.println("This is the output of the toStringArrayList() method: " + arr);

        return arr;
    }

    public ArrayList<Object> toObjectArrayList() // Optimize to only use ArrayList<Object> in this program!
    {
        ArrayList<Object> arr = new ArrayList<Object>();

        arr.add(title);
        arr.add(composer);
        arr.add(arranger);
        arr.add(publisher);
        arr.add(vbodaGrade.toString());
        arr.add(notes);

        return arr;
    }

    //toString
    // BUG: Make into better format
    public String toString()
    {
        return title + ", " +
            composer + ", " +
            arranger + ", " +
            publisher + ", " +
            vbodaGrade + ", " +
            notes;
    }
}
