import java.util.*;
public class Hangman {

	public static final String ANSI_BOLDCYAN = "\033[36;1m";
	public static final String ANSI_BOLDYELLOW = "\033[33;1m";
	public static final String ANSI_BOLD = "\033[0;1m";
	public static final String ANSI_LIGHTRED= "\033[0;3m"; 
	public static final String ANSI_RED = "\033[0;31m";
	public static final String ANSI_LIGHTYELLOW = "\033[0;41m";
	public static final String ANSI_YELLOW = "\033[0;33m";
	public static final String ANSI_LIGHTGREEN = "\033[0;40m";
	public static final String ANSI_GREEN = "\033[0;32m";
	public static final String ANSI_LIGHTBLUE = "\033[0;42m";
	public static final String ANSI_BLUE = "\033[0;34m";
	public static final String ANSI_MAGENTA = "\033[0;35m";
	public static final String ANSI_CYAN = "\033[0;36m";
	public static final String ANSI_WHITE = "\033[0;37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	HangmanDrawing draw = new HangmanDrawing();
	Vocab vocab = new Vocab();
	
	private String word;
	private char[] hiddenword;
	public static final int CHANCES = 6;
	private int mistakes = 0;
	private String guess;
	private ArrayList<String> letters = new ArrayList<>();
	
	public void getWord()
	{
		vocab.makeList("NIGHT");
		vocab.makeList("BOUND");
		vocab.makeList("STRONGER");
		vocab.makeList("WONDER");
		vocab.makeList("PARIS");
		vocab.makeList("VIOLENT");
		vocab.makeList("FANTASY");
		vocab.makeList("POOPOO");
		vocab.makeList("FOREVER");
		vocab.makeList("WOLVES");
		vocab.makeList("SECONDS");
		vocab.makeList("MONSTER");
		vocab.makeList("ADDICTION");
		vocab.makeList("AMAZING");
		vocab.makeList("BROTHER");
		vocab.makeList("CHAMPION");
		vocab.makeList("WINTER");
		vocab.makeList("BUSINESS");
		vocab.makeList("STRETCH");
		vocab.makeList("FEEDBACK");
	}
	
	public void startGame()
	{
		letters.clear();
		mistakes = 0;
		
		word = vocab.generateWord();
		
		hiddenword = new char[word.length()];
		
		for(int i = 0; i < hiddenword.length; i++)
		{
			hiddenword[i] = '*';
		}
		
		draw.drawHangman();
		System.out.println(hiddenword);
	}
	
	public void revealingWord(String c)
	{
		  if (!letters.contains(c))
		  {
		    if (word.contains(c))
		    {
		      int index = word.indexOf(c);

		      while (index >= 0) {
		        hiddenword[index] = c.charAt(0);
		        index = word.indexOf(c, index + 1);
		      }
		    } else
		    {
		      mistakes++;
		    }
		    letters.add(c);
		  }
	}
	
	private String wordDisplay() {
		  StringBuilder builder = new StringBuilder();

		  for (int i = 0; i < hiddenword.length; i++) {
		   builder.append(hiddenword[i]);

		   if (i < hiddenword.length - 1) {
		    builder.append(" ");
		   }
		  }

		  return builder.toString();
		 }
	
	public void logic()
	{
		Scanner input = new Scanner(System.in);
		int chances = 0;
		
		while(mistakes < CHANCES)
		{
			System.out.println("Enter a letter : ");
			
			guess = input.next().toUpperCase();
			
			if(guess.length() > 1)
			{
				guess = guess.substring(0,1);
			}
			
			revealingWord(guess);
			
			draw.hangmanImg((CHANCES - mistakes));
			System.out.println('\n' + wordDisplay());
			
			if(!wordDisplay().contains("*"))
			{
				mistakes = 7;
				System.out.println(ANSI_GREEN+ "You win! The word is : " + ANSI_RESET + word + '\n' + "Mr. Goblin was cured from his cancer! (for now)");
				break;
			}
			
			else if (!word.contains(guess))
			{
				System.out.println(ANSI_RED + "Wrong! Guess again" + ANSI_RESET);
				chances = CHANCES - mistakes;
			}	
			else
			{
				chances = CHANCES - mistakes;
			}
			
			System.out.println("Chances remaining : " + (chances));
		}
		
		if (mistakes == CHANCES)
		{
			System.out.println(ANSI_RED + "Game over, you lost! \nThe word was : " + ANSI_GREEN + word + ANSI_RESET + '\n' + "Mr. Goblin died due to complication with cancer, you monster.");
		}
	}	
}
