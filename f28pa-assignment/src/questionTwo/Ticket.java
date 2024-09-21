package questionTwo;

public class Ticket {
	
	//DATA FIELDS
	private char rowLetter;
	private int seatNo;
	private boolean isOccupied;
	private char[] row = {'A','B','C','D','E','F','G','H','I'};
	
	//CONSTRUCTORS
	Ticket(int rowIdx, int colIdx, boolean isOccupied) {
		this.rowLetter = row[rowIdx];
		this.seatNo = colIdx;
		this.isOccupied = isOccupied;
	}
	
	//METHODS
	public char getrowLetter() {
		return rowLetter;
	}
	
	public int getseatNo() {
		return seatNo;
	}
	
	public void setRowLetter(int rowIdx) {
		this.rowLetter = row[rowIdx];
	}
	
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	public boolean getisOccupied() {
		return isOccupied;
	}
	
	public void setisOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	public String toString() {
		return null;
	}
	
}