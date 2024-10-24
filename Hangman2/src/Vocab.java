import java.util.*;
public class Vocab {

	ArrayList<String> records = new ArrayList<String>();
	
	public Vocab()
	{
		
	}

	public void makeList(String word)
	{
		records.add(word);
	}
	
	public String generateWord()
	{
		Random rand = new Random();
		String word = records.get(rand.nextInt(20));
		return word;
	}
}
