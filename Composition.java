public class Composition
{
    //Instance variables
    private String title;
    private String composer;
    private String arranger;
    private int vbodaGrade;
    private String notes;
    private int pubYear;

    //Constructors; make more constructors later
    public Composition()
    {
        title = "";
        composer = "";
        arranger = "";
        vbodaGrade = 0;
        notes = "";
        pubYear = 0;
    }

    public Composition(String title, String composer, int pubYear)
    {
        this.title = title;
        this.composer = composer;
        arranger = "";
        vbodaGrade = 0;
        notes = "";
        this.pubYear = pubYear;
    }

    public Composition(String title, String composer, int vbodaGrade, String notes, int pubYear)
    {
        this.title = title;
        this.composer = composer;
        arranger = "";
        this.vbodaGrade = vbodaGrade;
        this.notes = notes;
        this.pubYear = pubYear;
    }

    public Composition(String title, String composer, String arranger, int vbodaGrade, String notes, int pubYear)
    {
        this.title = title;
        this.composer = composer;
        this.arranger = arranger;
        this.vbodaGrade = vbodaGrade;
        this.notes = notes;
        this.pubYear = pubYear;
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

    public int getVbodaGrade()
    {
        return vbodaGrade;
    }

    public String getNotes()
    {
        return notes;
    }

    public int getPubYear()
    {
        return pubYear;
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

    public void setVbodaGrade(int vbodaGrade)
    {
        this.vbodaGrade = vbodaGrade;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public void setPubYear(int pubYear)
    {
        this.pubYear = pubYear;
    }

    //toString
    public String toString()
    {
        return title + ", " +
            composer + ", " +
            arranger + ", " +
            vbodaGrade + ", " +
            notes + ", " +
            pubYear + ", ";
    }
}
