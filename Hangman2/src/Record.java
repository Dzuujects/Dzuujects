import java.time.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Record {

    Scanner input = new Scanner(System.in);
    Hangman hangman = new Hangman();

    String name;
    String ID;
    long startTime;
    long endTime;
    ArrayList nameList = new ArrayList<String>();
    ArrayList idList = new ArrayList<String>();
    ArrayList timeList = new ArrayList<Float>();

    public Record()
    {
        //default values
        this.name = "NoOne";
        this.ID = "H00001111";
    }

    public String getName()
    {
        System.out.println("Please enter your name : ");
        name = input.nextLine();
        nameList.add(name);
        return name;
    }

    public String getID()
    {
        System.out.println("Please enter your ID : ");
        ID = input.nextLine();
        idList.add(ID);
        return ID;
    }
    
    public long getStartTime()
    {
        startTime = System.currentTimeMillis();
        return startTime;
    }
    
    public long getEndTime()
    {
        endTime = System.currentTimeMillis();
        return endTime;
    }
    
    public float timeTaken()
    {
        float sec = (endTime - startTime) / 1000F;
        timeList.add(sec);
        return sec;
        
    }
    
    public void leaderboard()
    {
        for( int i = 0; i < nameList.size(); i++)
        {
            System.out.println(nameList.get(i) + " (" + idList.get(i) + ")" +  ": " + timeList.get(i) + "s");
        }
    }

    public void printDetails()
    {
        System.out.println("Student Name : " + name);
        System.out.println("Student ID : " + ID);
    }
}