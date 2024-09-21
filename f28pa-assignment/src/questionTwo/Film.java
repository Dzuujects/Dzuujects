package questionTwo;

public class Film {
	
	//DATA FIELDS
	protected String filmTitle;
	protected int sessionTime;
	
	//CONSTRUCTOR
	Film(String title, int sessionTime) {
		this.filmTitle = title;
		this.sessionTime = sessionTime;
	}
	
	//METHODS
	public String getSession() { //returns session
		
		String session = "";
		if (sessionTime == 1) {
			session = "Afternoon (1pm)";
		} else if (sessionTime == 2) {
			session = "Evening (5pm)";
		}else if (sessionTime == 3) {
			session = "Night (9pm)";
		}
		
		return session;
	}
	
	public String getTitle() { //returns title of film
		return filmTitle;
	}

}