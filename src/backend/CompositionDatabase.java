package src.backend;

import java.util.ArrayList;

//Database of exisiting composition and metadata for the search function
//

public class CompositionDatabase
{
    private static ArrayList<Composition> database = new ArrayList<Composition>();

    public ArrayList<Composition> populateDatabase()
    {
        return database;
    }
}
