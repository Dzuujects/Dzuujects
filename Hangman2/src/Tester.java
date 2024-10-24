import java.util.*;
import java.io.StringReader;

public class Tester {
	public static final String ANSI_BOLD = "\033[0;1m";
    public static final String ANSI_RESET = "\u001B[0m";
    	
	public static void main(String[]args)
	{		
		Record record = new Record();
	    Vocab vocab = new Vocab();
	    Hangman hangman = new Hangman();
	    HangmanDrawing draw = new HangmanDrawing();
	    Scanner input = new Scanner(System.in);
	    
		String playagain = "Y";
		
		
		
		do
		{
			hangman.getWord();
			
			System.out.println("WELCOME TO" + ANSI_BOLD + " HANGMAN!" + ANSI_RESET + " By " + ANSI_BOLD + "Dzuhair, Mansoor, Ahmed, and Nadesh" + ANSI_RESET);
            record.getName();
            record.getID();
            
            System.out.println("Mr. Goblin has " + ANSI_BOLD +  "stage  4 cancer " + ANSI_RESET +  "(real)," + '\n' + "guess the word correctly to cure him from his illness (for now)." + '\n' + "READY? SET... GO!");
           
            hangman.startGame();
            
            long start = System.currentTimeMillis();
            record.getStartTime();
            
            hangman.logic();
            
            long end = System.currentTimeMillis();
            record.getEndTime();
            float sec = (end - start) / 1000F;
            record.timeTaken();
            int time = (int) sec;
            
            record.printDetails();
            System.out.println("Time taken: " + time + " seconds");

            System.out.println("Press (Y/y) to play again!");
            playagain = input.next();
		} while(playagain.equalsIgnoreCase("y"));
		
        System.out.println("Scoreboard : ");
        System.out.println("======================================");
		record.leaderboard();
		System.out.println("======================================");
	}
}
