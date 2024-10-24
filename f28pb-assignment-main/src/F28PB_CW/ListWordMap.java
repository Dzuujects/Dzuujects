package F28PB_CW;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListWordMap implements IWordMap {
	
	private static class AddWord {
		String word;
		LinkedList<IPosition> position;
		
		AddWord(String w) {
			this.word = w;
			position = new LinkedList<>();
		}
		
		public LinkedList<IPosition> getPositionList() {
			return position;
		}	
		
		public String getWord() {
			return word;
		}
	} //Class so that wordList can hold a word and a list of positions
	
	private LinkedList<AddWord> wordList;
	
	public ListWordMap() {
		wordList = new LinkedList<>();
	} //Constructor
	
	@Override
	public void addPosition(String word, IPosition pos) {
		for (AddWord addedWord : wordList) {
			if (addedWord.getWord().equals(word)) {
				addedWord.getPositionList().add(pos);
				return;
			} //adds position of word is in the list already
		}
		AddWord newWord = new AddWord(word);
		newWord.getPositionList().add(pos);
		wordList.add(newWord);
		//adds words and list for words not in the list;
	}

	@Override
	public void removeWord(String word) throws WordException {
		ListIterator<AddWord> iterator = wordList.listIterator();
        while (iterator.hasNext()) {
            AddWord currentWord = iterator.next();
            if (currentWord.word.equals(word)) {
                iterator.remove();
                return;
            } //Finds the word in the map and removes
        }
		throw new WordException("Word is not found in files"); //throws exception if word is not found
	}

	@Override
	public void removePosition(String word, IPosition pos) throws WordException {
		for (AddWord currentWord : wordList) {
			if (currentWord.getWord().equals(word)){
				if (currentWord.getPositionList().remove(pos)) {
					return; //if word is available, delete position
				}else {
					throw new WordException("Postion of word not found in list"); //if position not found throw exception
				}
			}
		}
		throw new WordException("Word is not found in files"); //if word not found throw exception
	}

	@Override
	public Iterator<String> words() {
		LinkedList<String> words = new LinkedList<>();
		for (AddWord addedWord : wordList) { 
			words.add(addedWord.getWord()); 
		}
		return words.iterator();
	}//iterates words and adds them to list to print out
	
	public int wordCounter() {
		int wordCounter = 0;
		for (AddWord addedWord : wordList) {
			wordCounter++;
		}
		return wordCounter;
	}//counts the number of words

	@Override
	public Iterator<IPosition> positions(String word) throws WordException {
		for (AddWord addedWord : wordList) {
			if (addedWord.getWord().equals(word)) {
				return addedWord.getPositionList().iterator();
			} //Iterates position of words and returns them
		}throw new WordException("Word is not found in files"); //throws exception if files are not found
	} 

	@Override
	public int numberOfEntries() {
		int entries = 0;
		for (AddWord addedWord : wordList) {
			entries += addedWord.getPositionList().size();
		}
		return entries;
	}//counts the number of times the word shows and returns the number 
}
