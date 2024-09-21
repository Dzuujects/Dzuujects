package questionOne;
/**
 * F28PA | Software Development A | Coursework
 * 
 * The Coursework specification is provided in Canvas. Please read through it in
 * full before you start work.
 * 
 * @author Dzuhair Hakimi (H00421398)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AthleteAnalysis {
	//MAIN
	public static void main(String[] args) {
		//Inputs.
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		System.out.println("|-------------------HELLO! WELCOME TO ATHLETE ANALYSIS.----------------------|");
		System.out.println("What do you want to enter?");
		System.out.println("1. Enter Atheletes Manually");
		System.out.println("2. Use a Text File");
		userInput = scan.nextInt();
		
		if (userInput == 1){
			setEntries();
			enterAthletes();
		} else if (userInput == 2) {
			fileInput();
			fileSorter();
		}
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//1.
		genderCounter();
		genderRatio();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//2.
		meanAgeM();
		standardDeviationAgeM();
		System.out.println();
		meanAgeF();
		standardDeviationAgeF();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//3.
		meanHeightM();
		standardDeviationHeightM();
		System.out.println();
		meanHeightF();
		standardDeviationHeightF();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//4.
		meanWeightM();
		standardDeviationWeightM();
		System.out.println();
		meanWeightF();
		standardDeviationWeightF();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//5.
		oldestM();
		System.out.println();
		oldestF();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//6.
		youngestM();
		System.out.println();
		youngestF();
		System.out.println("|---------------------------------------------------------------------------------|");
		
		//7.
		numberOfSports();
		System.out.println("|---------------------------------------------------------------------------------|");
		
		//8.
		medalCountM();
		System.out.println();
		medalCountF();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//9.
		uniqueSportsMedalCountM();
		System.out.println();
		uniqueSportsMedalCountF();
		System.out.println("|-----------------------------------------------------------------------------|");
		
		//10.
		tablePrint();
		
	}
	
	//DATA FIELDS
	
	static Scanner in = new Scanner(System.in); //scanner
	
	static int N; //entries
	static File file;
	static Scanner fileReader;
	static String[] name; //name array || to test = {"Marie","James","Samara","Jakub","Shah","Joylin","Robert","Chong","Hayley","Ali","Travis","Tamir","Alex","Lim","Chloe","Karen","David","Lynn","Sofia","Sarah"};
	static String[] gender; //gender array || to test = {"f","m","f","m","m","f","m","m","f","m","m","m","m","f","f","f","m","f","f","f"}; //gender array
	static double[] age; //age array || to test = {26,18,23,22,23,25,21,25,21,23,24,25,19,20,22,24,22,24,24,24}; //age array
	static double[] height; //height array || to test = {160,165,165,170,170,170,172,174,175,175,175,175,180,180,180,180,185,185,185,185}; //height array
	static double[] weight; //weight array || to test = {55,65,65,75,80,60,55,65,60,75,85,85,65,70,75,70,60,70,75,80}; //weight array
	static String[] sports; //sports array || to test = {"Badminton","Badminton","Badminton","Gymnastics","Gymnastics","Badminton","Judo","Judo","Basketball","Judo","Gymnastics","Judo","Swimming","Swimming","Basketball","Basketball","Basketball","Swimming","Basketball","Basketball"}; //sports array
	static String[] medal; //medal array || to test = {"Bronze","Gold","Gold","Gold","Silver","Silver","Silver","Silver","Gold","Gold","Gold","Gold","Silver","Bronze","Bronze","Bronze","Bronze","Bronze","Silver","Silver"}; //medal array
	static String[] uniqueSports;
	
	static int numberOfM;
	static int numberOfF;
	
	static double meanOfAgeM;
	static double sdOfAgeM;
	static double meanOfHeightM;
	static double sdOfHeightM;
	static double meanOfWeightM;
	static double sdOfWeightM;
	static int oldestAgeM = 0;
	static String oldestNameM;
	static int youngestAgeM = 100;
	static String youngestNameM;
	
	static double meanOfAgeF;
	static double sdOfAgeF;
	static double meanOfHeightF;
	static double sdOfHeightF;
	static double meanOfWeightF;
	static double sdOfWeightF;
	static int oldestAgeF = 0;
	static String oldestNameF;
	static int youngestAgeF = 100;
	static String youngestNameF;
	
	//METHODS
	
	//set entries
	public static int setEntries() {
		
		boolean check = false;
		
		while (!check) {
			System.out.println("How many entries are you inputing?");
				N = in.nextInt();
				if (N < 1) System.out.println("Please enter a proper number");
				else check = true;
			}
		
		name = new String[N];
		gender = new String[N];
		age = new double[N];
		height = new double[N];
		weight = new double[N];
		sports = new String[N];
		medal = new String[N];
		return N;
	} 
	
	//input into arrays
	public static void enterAthletes() {
		boolean check;
		
		for (int i = 0; i < N; i++) {
			System.out.println("Please enter Athlete " + (i+1) + " name");
			name[i] = in.next();
			
			check = false;
			while (!check) {
				System.out.println("Please enter Athlete " + (i+1) + " gender (F/M)");
				gender[i] = in.next();
				if (gender[i].equalsIgnoreCase("F") || gender[i].equalsIgnoreCase("M") ) check = true;
				else System.out.println("Error. Invalid input"); 
			}
			
			System.out.println("Please enter Athlete " + (i+1) + " age");
			age[i] = in.nextInt();
			
			System.out.println("Please enter Athlete " + (i+1) + " height");
			height[i] = in.nextDouble();
			
			System.out.println("Please enter Athlete " + (i+1) + " weight");
			weight[i] = in.nextDouble();
			
			System.out.println("Please enter Athlete " + (i+1) + " sport");
			sports[i] = in.next();
			
			check = false;
			while (!check) {
				check = false;
				System.out.println("Please enter Athlete " + (i+1) + " medal");
				medal[i] = in.next();
				if (medal[i].equalsIgnoreCase("bronze") || medal[i].equalsIgnoreCase("silver") || medal[i].equalsIgnoreCase("gold")) {
					check = true;
				} else System.out.println("Error. Invalid Input");
			}
		}
	}
	
	//file input and sorter
	
	public static void fileInput() {
		System.out.println("Please enter a file (example: data.txt).");
		file = new File(in.next());
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileSorter() {
		N = Integer.parseInt(fileReader.next().substring(0,2));
		fileReader.nextLine();
		name = new String[N];
		gender = new String[N];
		age = new double[N];
		height = new double[N];
		weight = new double[N];
		sports = new String[N];
		medal = new String[N];
			
			for (int i = 0; i < N; i++) {
				String[] tempArray = fileReader.next().split(",");
				name[i] = tempArray[0];
				gender[i] = tempArray[1];
				age[i] = Double.parseDouble(tempArray[2]);
				height[i] = Double.parseDouble(tempArray[3]);
				weight[i] = Double.parseDouble(tempArray[4]);
				sports[i] = tempArray[5];
				medal[i] = tempArray[6];
			}	
	}
		
	
	//separate genders
	
	public static void genderCounter() { //get the number of Male and Female
		numberOfM = 0;
		numberOfF = 0;
		
		for (int i = 0; i < gender.length; i++) {
			if (gender[i].equalsIgnoreCase("F")) numberOfF++;
			else if (gender[i].equalsIgnoreCase("M")) numberOfM++;
		}
	}
	
	public static String[] makeStringArrayM(String[] arr) {
		String[] arrayM = new String[numberOfM];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if(gender[i].equalsIgnoreCase("M")){
				arrayM[j] = arr[i];
				j++;
			}
		}
		return arrayM;
	}
	
	public static String[] makeStringArrayF(String[] arr) {
		String[] arrayF = new String[numberOfF];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if(gender[i].equalsIgnoreCase("F")){
				arrayF[j] = arr[i];
				j++;
			}
		}
		return arrayF;
	}
	
	public static double[] makeDoubleArrayM(double[] arr) {
		double[] arrayM = new double[numberOfM];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if(gender[i].equalsIgnoreCase("M")){
				arrayM[j] = arr[i];
				j++;
			}
		}
		return arrayM;
	}
	
	public static double[] makeDoubleArrayF(double[] arr) {
		double[] arrayF = new double[numberOfF];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if(gender[i].equalsIgnoreCase("F")){
				arrayF[j] = arr[i];
				j++;
			}
		}
		return arrayF;
	}
	
	//calculation
	
	public static int greatestCommonDivisor(int m, int f) { //find the greatest common ratio using https://codereview.stackexchange.com/questions/26697/getting-the-smallest-possible-integer-ratio-between-two-numbers accessed at 20/10/2023
		if (f == 0) return m;
		else return greatestCommonDivisor(f,m % f);
	}
	
	public static void genderRatio() { //calculate gender ratio using https://codereview.stackexchange.com/questions/26697/getting-the-smallest-possible-integer-ratio-between-two-numbers accessed at 20/10/2023
		int gcd = greatestCommonDivisor(numberOfM,numberOfF);
		System.out.println("Gender Ratio is "+numberOfM/gcd+":"+numberOfF/gcd);
	}
	
	public static void meanAgeM() { //calculate and show mean age of male
		double[] maleAge = makeDoubleArrayM(age);
		
		double sum = 0;
		for (int i = 0; i < maleAge.length; i++) {
			sum = sum + maleAge[i];
		}
		meanOfAgeM = sum/maleAge.length;
		
		System.out.printf("Mean age of male athletes is %.2f years old\n",meanOfAgeM);
	}
	
	public static void standardDeviationAgeM() { //calculate and show standard deviation age of male
		double[] maleAge = makeDoubleArrayM(age);
		
		double sumOfSquares = 0;
		for (int i = 0; i < maleAge.length; i++) {
			double difference = maleAge[i] - meanOfAgeM; //difference between current age and mean age
			sumOfSquares = sumOfSquares + Math.pow(difference, 2);
		}
		double variation = sumOfSquares/numberOfM; //division between sum of square and mean
		sdOfAgeM = Math.sqrt(variation);
		
		System.out.printf("Standard deviation of age of male athletes is %.2f years old\n",sdOfAgeM);
	}
	
	public static void meanHeightM() { //calculate and show mean height of male
		double[] maleHeight = makeDoubleArrayM(height);
		
		double sum = 0;
		for (int i = 0; i < maleHeight.length; i++) {
			sum = sum + maleHeight[i];
		}
		meanOfHeightM = sum/maleHeight.length;
		
		System.out.printf("Mean height of male athletes is %.2fcm\n",meanOfHeightM);
	}
	
	public static void standardDeviationHeightM() { //calculate and show standard deviation height of male
		double[] maleHeight = makeDoubleArrayM(height);
		
		double sumOfSquares = 0;
		for (int i = 0; i < maleHeight.length; i++) {
			double difference = maleHeight[i] - meanOfHeightM; //difference between current height and mean height
			sumOfSquares = sumOfSquares + Math.pow(difference, 2);
		}
		double variation = sumOfSquares/numberOfM; //division between sum of square and mean
		sdOfHeightM = Math.sqrt(variation);
		
		System.out.printf("Standard deviation of height of male athletes is %.2fcm\n",sdOfHeightM);
	}
	
	public static void meanWeightM() { //calculate and show mean weight of male
		double[] maleWeight = makeDoubleArrayM(weight);
		
		double sum = 0;
		for (int i = 0; i < maleWeight.length; i++) {
			sum = sum + maleWeight[i];
		}
		meanOfWeightM = sum/maleWeight.length;
		
		System.out.printf("Mean weight fo male athletes is %.2fkg\n",meanOfWeightM);
	}
	
	public static void standardDeviationWeightM() { //calculate and show standard deviation weight of male
		double[] maleWeight = makeDoubleArrayM(weight);
		
		double sumOfSquares = 0;
		for (int i = 0; i < maleWeight.length; i++) {
			double difference = maleWeight[i] - meanOfWeightM; //difference between current weight and mean weight
			sumOfSquares = sumOfSquares + Math.pow(difference, 2);
		}
		double variation = sumOfSquares/numberOfM; //division between sum of square and mean
		sdOfWeightM = Math.sqrt(variation);
		
		System.out.printf("Standard deviation of weight of male athletes is %.2fkg\n",sdOfWeightM);
	}
	
	public static void oldestM() { // shows oldest male athlete
		String[] maleName = makeStringArrayM(name);
		double[] maleAge = makeDoubleArrayM(age);
		
		for (int i = 0; i < numberOfM ; i++) {
			if (maleAge[i] > oldestAgeM) {
				oldestAgeM = (int) maleAge[i];
				oldestNameM = maleName [i];
			}
		}
		System.out.printf("Oldest male athlete is %s at %d years old\n",oldestNameM,oldestAgeM);
	}
	
	public static void youngestM() { // shows youngest male athlete
		String[] maleName = makeStringArrayM(name);
		double[] maleAge = makeDoubleArrayM(age);
		
		for (int i = 0; i < numberOfM ; i++) {
			if (maleAge[i] < youngestAgeM) {
				youngestAgeM = (int) maleAge[i];
				youngestNameM = maleName [i];
			}
		}
		System.out.printf("Youngest male athlete is %s at %d years old\n",youngestNameM,youngestAgeM);
	}
	
	public static void meanAgeF() { //calculate and show mean age of female
		double[] femaleAge = makeDoubleArrayF(age);
		
		double sum = 0;
		for (int i = 0; i < femaleAge.length; i++) {
			sum = sum + femaleAge[i];
		}
		meanOfAgeF = sum/femaleAge.length;
		
		System.out.printf("Mean age of female athletes is %.2f years old\n",meanOfAgeF);
	}
	
	public static void standardDeviationAgeF() { //calculate and show standard deviation age of female
		double[] femaleAge = makeDoubleArrayF(age);
		
		double sumOfSquares = 0;
		for (int i = 0; i < femaleAge.length; i++) {
			double difference = femaleAge[i] - meanOfAgeM; //difference between current age and mean age
			sumOfSquares = sumOfSquares + Math.pow(difference, 2);
		}
		double variation = sumOfSquares/numberOfF; //division between sum of square and mean
		sdOfAgeF = Math.sqrt(variation);
		
		System.out.printf("Standard deviation of age of female athletes is %.2f years old\n",sdOfAgeF);
	}
	
	public static void meanHeightF() { //calculate and show mean height of female
		double[] femaleHeight = makeDoubleArrayF(height);
		
		double sum = 0;
		for (int i = 0; i < femaleHeight.length; i++) {
			sum = sum + femaleHeight[i];
		}
		meanOfHeightF = sum/femaleHeight.length;
		
		System.out.printf("Mean height of female athletes is %.2fcm\n",meanOfHeightF);
	}
	
	public static void standardDeviationHeightF() { //calculate and show standard deviation height of female
		double[] femaleHeight = makeDoubleArrayF(height);
		
		double sumOfSquares = 0;
		for (int i = 0; i < femaleHeight.length; i++) {
			double difference = femaleHeight[i] - meanOfHeightF; //difference between current height and mean height
			sumOfSquares = sumOfSquares + Math.pow(difference, 2);
		}
		double variation = sumOfSquares/numberOfF; //division between sum of square and mean
		sdOfHeightF = Math.sqrt(variation);
		
		System.out.printf("Standard deviation of height female athletes is %.2fcm\n",sdOfHeightF);
	}
	
	public static void meanWeightF() { //calculate and show mean weight of female
		double[] femaleWeight = makeDoubleArrayF(weight);
		
		double sum = 0;
		for (int i = 0; i < femaleWeight.length; i++) {
			sum = sum + femaleWeight[i];
		}
		meanOfWeightF = sum/femaleWeight.length;
		
		System.out.printf("Mean weight of female athletes is %.2fkg\n",meanOfWeightF);
	}
	
	public static void standardDeviationWeightF() { //calculate and show standard deviation weight of female
		double[] femaleWeight = makeDoubleArrayF(weight);
		
		double sumOfSquares = 0;
		for (int i = 0; i < femaleWeight.length; i++) {
			double difference = femaleWeight[i] - meanOfWeightF; //difference between current weight and mean weight
			sumOfSquares = sumOfSquares + Math.pow(difference, 2);
		}
		double variation = sumOfSquares/numberOfF; //division between sum of square and mean
		sdOfWeightF = Math.sqrt(variation);
		
		System.out.printf("Standard deviation of weight of female athletes is %.2fkg\n",sdOfWeightF);
	}
	
	public static void oldestF() { //shows oldest female athlete
		String[] femaleName = makeStringArrayF(name);
		double[] femaleAge = makeDoubleArrayF(age);
		
		for (int i = 0; i < numberOfF ; i++) {
			if (femaleAge[i] > oldestAgeF) {
				oldestAgeF = (int) femaleAge[i];
				oldestNameF = femaleName [i];
			}
		}
		System.out.printf("Oldest female athlete is %s at %d years old\n",oldestNameF,oldestAgeF);
	}
	
	public static void youngestF() { //shows youngest female athlete
		String[] femaleName = makeStringArrayF(name);
		double[] femaleAge = makeDoubleArrayF(age);
		
		for (int i = 0; i < numberOfF ; i++) {
			if (femaleAge[i] < youngestAgeF) {
				youngestAgeF = (int) femaleAge[i];
				youngestNameF = femaleName [i];
			}
		}
		System.out.printf("Youngest female athlete is %s at %d years old\n",youngestNameF,youngestAgeF);
	}
	
	public static void numberOfSports() { //counts and displays the number of unique sports
		String text ="";
		int counter = 0;
		int j;
		for (int i = 0; i < sports.length; i++) {
			boolean check = false;
			for (j = 0; j < i; j++) {
				if (sports[i].equalsIgnoreCase(sports[j])) {
					check = true;
					break;
				}
			}
			if (!check) {
				text = text + sports[j] +", ";
				counter++;
			}
		}
		
		uniqueSports = text.split(", ");
		
		System.out.printf("There are %d sports and they are %s\n",counter,text);
	}
	
	public static void medalCountM() { //count number of medals for Male athletes
		String[] maleMedal = makeStringArrayM(medal);
		String[] femaleMedal = makeStringArrayF(medal);
		
		int bronzeM = 0;
		int silverM = 0;
		int goldM = 0;
		for (int i = 0; i < maleMedal.length; i++) {
			if (maleMedal[i].equalsIgnoreCase("bronze")) {
				bronzeM++;
			}
			if (maleMedal[i].equalsIgnoreCase("silver")) {
				silverM++;
			}
			if (maleMedal[i].equalsIgnoreCase("gold")) {
				goldM++;
			}
		}
		System.out.printf("Total medals male athelete got:\nGold - %d\nSilver - %d\nBronze - %d\n",goldM,silverM,bronzeM);
	}
	
	public static void medalCountF() { //count number of medals for female athletes
		String[] femaleMedal = makeStringArrayF(medal);
		
		int bronzeF = 0;
		int silverF = 0;
		int goldF = 0;
		for (int i = 0; i < femaleMedal.length; i++) {
			if (femaleMedal[i].equalsIgnoreCase("bronze")) {
				bronzeF++;
			}
			if (femaleMedal[i].equalsIgnoreCase("silver")) {
				silverF++;
			}
			if (femaleMedal[i].equalsIgnoreCase("gold")) {
				goldF++;
			}
		}
		System.out.printf("Total medals female athelete got:\nGold - %d\nSilver - %d\nBronze - %d\n",goldF,silverF,bronzeF);
	}
	
	public static void uniqueSportsMedalCountM() { //count number of medals for each sports for male athletes
		String[] maleSports = makeStringArrayM(sports);
		String[] maleMedal = makeStringArrayM(medal);
		
		for (int i = 0; i < uniqueSports.length; i++) {
			
			int bronzeM = 0;
			int silverM = 0;
			int goldM = 0;
			
			for (int j = 0;j < maleSports.length; j++) {
				if (maleSports[j].equalsIgnoreCase(uniqueSports[i])) {
					if (maleMedal[i].equalsIgnoreCase("bronze")) {
						bronzeM++;
					}
					if (maleMedal[i].equalsIgnoreCase("silver")) {
						silverM++;
					}
					if (maleMedal[i].equalsIgnoreCase("gold")) {
						goldM++;
					}
				}
			}
			System.out.printf("Total medals male atheletes got for %s:\nGold - %d\nSilver - %d\nBronze - %d\n",uniqueSports[i],goldM,silverM,bronzeM);
		}
	}
	
	public static void uniqueSportsMedalCountF() { //count number of medals for each sports for female athletes
		String[] femaleSports = makeStringArrayF(sports);
		String[] femaleMedal = makeStringArrayF(medal);
		
		for (int i = 0; i < uniqueSports.length; i++) {
			
			int bronzeF = 0;
			int silverF = 0;
			int goldF = 0;
			
			for (int j = 0;j < femaleSports.length; j++) {
				if (femaleSports[j].equalsIgnoreCase(uniqueSports[i])) {
					if (femaleMedal[i].equalsIgnoreCase("bronze")) {
						bronzeF++;
					}
					if (femaleMedal[i].equalsIgnoreCase("silver")) {
						silverF++;
					}
					if (femaleMedal[i].equalsIgnoreCase("gold")) {
						goldF++;
					}
				}
			}
			System.out.printf("Total medals female atheletes got for %s:\nGold - %d\nSilver - %d\nBronze - %d\n",uniqueSports[i],goldF,silverF,bronzeF);
		}
	}
	
	public static void tablePrint() {
		System.out.println("||==========================================================================||");
		System.out.printf("|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n","NAME","GENDER","AGE","HEIGHT","WEIGHT","SPORTS","MEDAL");
		System.out.println("||==========================================================================||");
		for (int i = 0; i < N; i++) {
			System.out.printf("|%10s|%10s|%10d|%10.2f|%10.2f|%10s|%10s|\n",name[i].toUpperCase(),gender[i].toUpperCase(),(int)age[i],height[i],weight[i],sports[i].toUpperCase(),medal[i].toUpperCase());
		}
		System.out.println("||==========================================================================||");
	}
}