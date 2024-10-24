
public class HangmanDrawing {

	Vocab vocab = new Vocab();
	static int chances = 6;
	//BOLD COLORS
	public static final String ANSI_BOLDCYAN = "\033[36;1m";
	public static final String ANSI_BOLDYELLOW = "\033[33;1m";
	public static final String ANSI_BOLD = "\033[0;1m";
		
	//MANSOORS ANSI COLORS
	   public static final String ANSI_GREEN = "\033[38;5;190m";
	    public static final String ANSI_DARKGREEN = "\033[38;5;184m";
	    public static final String ANSI_YELLOW = "\033[38;5;178m";
	    public static final String ANSI_DARKYELLOW = "\033[38;5;172m";
	    public static final String ANSI_RED = "\033[38;5;166m";
	    public static final String ANSI_DARKRED= "\033[38;5;160m";
	//TESTING COLORS 
		public static final String ANSI_ORANGE = "\033[0;38m";
		
		//STANDARD COLOLRS
		public static final String ANSI_LIGHTRED= "\033[0;3m"; 
	
		public static final String ANSI_LIGHTYELLOW = "\033[0;41m";
	
		public static final String ANSI_LIGHTGREEN = "\033[0;40m";
	
		public static final String ANSI_LIGHTBLUE = "\033[0;42m";
		public static final String ANSI_BLUE = "\033[0;34m";
		public static final String ANSI_MAGENTA = "\033[0;35m";
		public static final String ANSI_CYAN = "\033[0;36m";
		public static final String ANSI_WHITE = "\033[0;37m";
		
		//RESET
		public static final String ANSI_RESET = "\u001B[0m";
		
		public void drawHangman()
		{
			//Mansoor will make this
			long startTime = System.currentTimeMillis();
			long endTime = System.currentTimeMillis();
			long duration = ( endTime - startTime);
			
			System.out.println(ANSI_GREEN + "     __________________");
			System.out.println(ANSI_GREEN + "    /                   \\");
			System.out.println(ANSI_GREEN + "   /                     \\");
			System.out.println(ANSI_GREEN + "  /       ^     ^         \\");
			System.out.println(ANSI_GREEN + " |                         |");
			System.out.println(ANSI_GREEN + " \\                        /");
			System.out.println(ANSI_GREEN + "  \\                      /");
			System.out.println(ANSI_GREEN + "   \\    ___________     / ");
			System.out.println(ANSI_GREEN + "    /   |          /    |");
			System.out.println(ANSI_GREEN + "   /____|         /_____|"+ ANSI_RESET);
			System.out.println(ANSI_GREEN + "Remaining chances:" + ANSI_BOLDYELLOW + " 6" + ANSI_RESET);
		
		}
		
		 public static void hangmanImg(int chances) {
		        if (chances == 5) {
		        	System.out.println(ANSI_DARKGREEN+ "     __________________");
					System.out.println(ANSI_DARKGREEN+ "    /                   \\");
					System.out.println(ANSI_DARKGREEN+ "   /                     \\");
					System.out.println(ANSI_DARKGREEN+ "  /       ^     ^         \\");
					System.out.println(ANSI_DARKGREEN+ " |                         |");
					System.out.println(ANSI_DARKGREEN+ " \\                        /");
					System.out.println(ANSI_DARKGREEN+ "  \\                      /");
					System.out.println(ANSI_DARKGREEN+ "   \\    ___________     / ");
					System.out.println(ANSI_DARKGREEN+ "    /   |          /    |");
					System.out.println(ANSI_DARKGREEN+ "   /____|         /_____|"+ ANSI_RESET);
		          
		        }
		        if (chances == 4) {
		        	System.out.println(ANSI_YELLOW + "     __________________");
					System.out.println(ANSI_YELLOW + "    /                   \\");
					System.out.println(ANSI_YELLOW+ "   /                     \\");
					System.out.println(ANSI_YELLOW + "  /       O     O         \\");
					System.out.println(ANSI_YELLOW+ " |                         |");
					System.out.println(ANSI_YELLOW+ " \\                        /");
					System.out.println(ANSI_YELLOW + "  \\                      /");
					System.out.println(ANSI_YELLOW+ "   \\    ___________     / ");
					System.out.println(ANSI_YELLOW + "    /   |          /    |");
					System.out.println(ANSI_YELLOW+ "   /____|         /_____|"+ ANSI_RESET);
		    
		        }
		        if (chances == 3) {
		        	System.out.println(ANSI_DARKYELLOW + "     __________________");
					System.out.println(ANSI_DARKYELLOW+ "    /                   \\");
					System.out.println(ANSI_DARKYELLOW + "   /                     \\");
					System.out.println(ANSI_DARKYELLOW + "  /       o     o         \\");
					System.out.println(ANSI_DARKYELLOW + " |                         |");
					System.out.println(ANSI_DARKYELLOW + " \\                        /");
					System.out.println(ANSI_DARKYELLOW + "  \\                      /");
					System.out.println(ANSI_DARKYELLOW + "   \\    ___________     / ");
					System.out.println(ANSI_DARKYELLOW + "    /   |          /    |");
					System.out.println(ANSI_DARKYELLOW + "   /____|         /_____|"+ ANSI_RESET);
		   
		        }
		        if (chances == 2) {
		        	System.out.println(ANSI_RED + "     __________________");
					System.out.println(ANSI_RED + "    /                   \\");
					System.out.println(ANSI_RED + "   /                     \\");
					System.out.println(ANSI_RED + "  /       _      _        \\");
					System.out.println(ANSI_RED + " |                         |");
					System.out.println(ANSI_RED + " \\                        /");
					System.out.println(ANSI_RED+ "  \\                      /");
					System.out.println(ANSI_RED + "   \\    ___________     / ");
					System.out.println(ANSI_RED + "    /   |          /    |");
					System.out.println(ANSI_RED + "   /____|         /_____|"+ ANSI_RESET);
		        
		        }
		        if (chances == 1) {
		        	System.out.println(ANSI_DARKRED + "     __________________");
					System.out.println(ANSI_DARKRED + "    /                   \\");
					System.out.println(ANSI_DARKRED + "   /                     \\");
					System.out.println(ANSI_DARKRED + "  /       _      _        \\");
					System.out.println(ANSI_DARKRED + " |                         |");
					System.out.println(ANSI_DARKRED+ " \\                        /");
					System.out.println(ANSI_DARKRED + "  \\                      /");
					System.out.println(ANSI_DARKRED + "   \\    ___________     / ");
					System.out.println(ANSI_DARKRED + "    /   |          /    |");
					System.out.println(ANSI_DARKRED + "   /____|         /_____|"+ ANSI_RESET);
		        
		        }
		        if (chances == 0) {
		        	System.out.println(ANSI_DARKRED + "     __________________");
					System.out.println(ANSI_DARKRED + "    /                   \\");
					System.out.println(ANSI_DARKRED + "   /                     \\");
					System.out.println(ANSI_DARKRED + "  /       x      x        \\");
					System.out.println(ANSI_DARKRED + " |                         |");
					System.out.println(ANSI_DARKRED + " \\                        /");
					System.out.println(ANSI_DARKRED + "  \\                      /");
					System.out.println(ANSI_DARKRED + "   \\    ___________     / ");
					System.out.println(ANSI_DARKRED + "    /   |          /    |");
					System.out.println(ANSI_DARKRED + "   /____|         /_____|"+ ANSI_RESET);
		    	
		        }

		    }
}
