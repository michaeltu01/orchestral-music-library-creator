import java.util.ArrayList;

public class RawData 
{
    //ArrayList variable
    private ArrayList<Composition> metadata;


    //Constructor
    public RawData()
    {
        metadata = new ArrayList<Composition>();
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

    }

    public ArrayList<Composition> sortByVbodaGrade() //Returns metadata sort by VbodaGrade descending (6-1)
    {

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
