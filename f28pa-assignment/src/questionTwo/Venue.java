package questionTwo;

public class Venue {
	
	//DATA FIELDS
	private String id;
	private int noRows;
	private int noCols;
	private Ticket[][] ticket;
	private int numOfTickets;
	private int numOfSeatsOccupied;
	
	//CONSTRUCTORS
	Venue(String id){
		this.id = id;
		if (id.charAt(1) == 'E') {
			noRows = 7;
		}else if (id.charAt(1) == 'W') {
			noRows = 5;
		}else if (id.charAt(1) == 'N') {
			noRows = 7;
		}else if (id.charAt(1) == 'S') {
			noRows = 9;
		}
		
		if (id.charAt(1) == 'E') {
			noCols = 7;
		}else if (id.charAt(1) == 'W') {
			noCols = 7;
		}else if (id.charAt(1) == 'N') {
			noCols = 5;
		}else if (id.charAt(1) == 'S') {
			noCols = 9;
		}
		
		this.ticket = new Ticket[noRows][noCols];
		for (int i = 0; i <  noRows; i++) {
			for (int j = 0; j < noCols; j++) {
			ticket[i][j] = new Ticket(i,j,false);
			}
		}
		
	}
	
	//METHODS
	public String getID() {
		return id;
	}
	
	public int getNoRows() {
		return noRows;
	}
	
	public int getNoCol() {
		return noCols; 
	}
	
	public int getNumOfTickets() {
		numOfTickets = noRows * noCols;
		return numOfTickets;	
	}
	
	public int getNumOfSeatsOccupied() {
		return numOfSeatsOccupied;
	}
	
	public void bookASeat (int rowIdx, int seatNo) { //books the seat and makes it occupied
		this.ticket[rowIdx][seatNo].setRowLetter(rowIdx);
		this.ticket[rowIdx][seatNo].setSeatNo(seatNo);
		this.ticket[rowIdx][seatNo].setisOccupied(true);
	}
	
	public boolean checkOccupied(int rowIdx, int seatNo) { //checks if seat is occupied
		if (ticket[rowIdx][seatNo].getisOccupied()) return true;
		else return false;
	}
	
	public String seatVenueDisplay() { //displays venue as a grid
		String display = "";
		
		for (int i = 0; i < noRows; i++) {
			for (int j = 0; j < noCols; j++) {	
				display = display + "{" + rowIndex2Letter(i) + j +"} ";
			}
			display = display + "\n";
		}
		return display;
	} 
	
	public boolean checkIfVenueIsFull() {
		if (numOfTickets == numOfSeatsOccupied) {
			return true;
		} else return false;
	}

	// Note: this static method is given
	// Converts row letter (char) to index number (int)
	public static int rowLetter2Idx(char letter) {
		return (int) (letter) - 65;
	}

	// Note: this static method is given
	// Converts index number (int) to row letter (char)
	public static char rowIndex2Letter(int idx) {
		return (char) (idx + 'A');
	}
	
	public String toString() {
		return null;
	}
}