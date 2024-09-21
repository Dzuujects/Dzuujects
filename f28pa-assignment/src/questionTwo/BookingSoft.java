package questionTwo;

import java.util.InputMismatchException;
/**
 * F28PA | Software Development A | Coursework
 * 
 * The Coursework specification is provided in Canvas. Please read through it in
 * full before you start work.
 * 
 * @author Dzuhair Hakimi (H00421398)
 */
import java.util.Scanner;
public class BookingSoft {
	public static void main(String[] args) throws InterruptedException {
		// There are currently 6 shows offered in 6 different venues.
		Show[] shows = new Show[6];
		
		// Uncomment lines 17 to 22 once the constructors have been written.
		shows[0] = new Show("1N", new Film("SING", 1));
		shows[1] = new Show("2W", new Film("THE GRINCH", 2));
		shows[2] = new Show("3E", new Film("BOSS BABY", 3));
		shows[3] = new Show("3S", new Film("YES DAY", 3));
		shows[4] = new Show("1E", new Film("THE KARATE KID", 1));
		shows[5] = new Show("2N", new Film("THE SEA BEAST", 2));
		System.out.println("### Welcome to the Booking System ###\n");
		// DO NOT CHANGE THE ABOVE PART OF THE CODE.
		///////////////////////////////////////////////////////////////////////////////////
		Scanner in = new Scanner(System.in);
		boolean check = false;
		
		
		System.out.println("BELOW ARE THE LIST OF SHOWS AVAILABLE");
		System.out.println("=====================================================================");
			
		//print the halls
		for (int i = 0; i < shows.length; i++) {
			System.out.println("SHOW: " + i);
			shows[i].printHall();
		}
		System.out.println("=====================================================================");
		System.out.println("Please enter a which show you want to watch (0-5).");
		int hallIn = in.nextInt();
		System.out.println("=====================================================================");
		System.out.println("You have chosen " + shows[hallIn].getFilmName() + " in the " + shows[hallIn].getSessionTime() + ".");
			
		while(!check) { //loops until user says "n" or "no"
			System.out.println("Below is the seats available for the show.\n");
			System.out.println(shows[hallIn].printVenue());
			
			//exception check for seat no
			boolean ticketCheck = false;
			
			while(!ticketCheck) {
			
				System.out.println("Please enter the chosen row.");
				char rowLetter = 0;
				boolean rowCheck = false;
				while (!rowCheck) {
					try {
						rowLetter = in.next().toUpperCase().charAt(0);
					
					} catch (InputMismatchException e) {
						System.out.println("Please enter only one Letter correspoding to to seats.");
						}finally {
							rowCheck = true;
						}
				}
			
				//exception check for seat no
				boolean seatCheck = false;
				int seatNo = 0;
				while (!seatCheck) {
					System.out.println("Please enter the chosen seat number.");
					
					try {
						seatNo = in.nextInt();
					
					} catch (InputMismatchException e) {
						System.out.println("Please enter only one Number correspoding to to seats.");
						}finally {
							seatCheck = true;
						}
				}
				if(!shows[hallIn].checkSeatAvailability(rowLetter,seatNo)) {
					System.out.printf("Seat is available.\n");
					shows[hallIn].addToPrint(rowLetter, seatNo);
					System.out.println("=====================================================================");
					shows[hallIn].buyTicket(rowLetter, seatNo);
					ticketCheck = true;
				} else {
					System.out.printf("Seat is booked. Please select another seat.\n");
				}
			}
			System.out.println("Do you want to book another ticket for the same show (y/n)?");
			String YorN = in.next();
			
			boolean yornCheck = false;
				while (!yornCheck) {
					yornCheck = false;
					if (YorN.equalsIgnoreCase("n") || YorN.equalsIgnoreCase("no")) {
						shows[hallIn].printTicket();
						System.out.println("Thank you! See you then!");
						check = true;
						yornCheck = true;
					} else if (YorN.equalsIgnoreCase("y") || YorN.equalsIgnoreCase("yes")){
						yornCheck = true;
					} else {
						System.out.println("Please enter y or n");
					}
			}
		}
	}
}
