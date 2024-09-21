package questionTwo;

import java.util.Random;
public class Show {
	
	//DATA FIELDS
	private Film filmName;
	private Venue venueId;
	private String print = "";
	
	//CONSTRUCTORS
	Show(String venueId, Film filmName) {
		this.venueId = new Venue(venueId);
		this.filmName = filmName;
	}
	
	//METHODS
	
	public String getFilmName() {
		return filmName.getTitle();
	}
	
	public String getSessionTime() {
		return filmName.getSession();
	}
	
	public String printVenue() { //print the venue as a grid
		return venueId.seatVenueDisplay();
	}
	
	public void buyTicket(char row, int seatNo) { //makes the ticket unavailable
		venueId.bookASeat(venueId.rowLetter2Idx(row), seatNo);
	}
	
	public void printAvailability() {
		if (venueId.checkIfVenueIsFull()) {
			System.out.println("Venue is full");
		}else System.out.println("Venue is not full");
	}
	
	public boolean checkSeatAvailability(char row, int seatNo) { //checks seat availability
		if (!venueId.checkOccupied(venueId.rowLetter2Idx(row),seatNo)) return false;
		else return true;
	}
	
	public void printHall() { //print all available halls
		System.out.println("MOVIE: " + filmName.getTitle());
		System.out.println("VENUE: " + venueId.getID());
		System.out.println("NUMBER OF SEATS AVAILABLE: " + (venueId.getNumOfTickets()) + "\n");
	}
	
	public String locationInfo() { //Shows info of the movie and location
		String location = "You chose to watch " + filmName.getTitle() + " at " + venueId.getID() + ".";
			return location;
	}
	
	public String addToPrint(char row, int seatNo) {//adds seat number to a string to print later.
		print = print + "{" + row + "," + seatNo + "} ";
		return print;
	}
	
	public void printTicket() { //prints tickets at the end
		Random rand = new Random();
		System.out.println("===================================================================");
		System.out.printf("TICKET SERIAL NUMBER: #%6d\n",rand.nextInt(1000000));
		System.out.printf("MOVIE TITLE: %s\n",getFilmName());
		System.out.printf("TIME: %s\n",getSessionTime());
		System.out.printf("VENUE: %s\n",venueId.getID());
		System.out.printf("SEAT NUMBER(S): %s\n",print);
		System.out.println("===================================================================\n");
	}
	
	public String toString() {
		return null;
	}
}