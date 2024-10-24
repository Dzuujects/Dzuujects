package F28PB_CW;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class ListWordMapTest {

	// Add your own tests
	ListWordMap map;
	String word1 = "test1";
	String word2 = "test2";
	IPosition pos1 = new WordPosition("test.txt", 4, word1);
	IPosition pos2 = new WordPosition("test.txt", 5, word2);
	IPosition pos3 = new WordPosition("test.txt", 3, word2);
	
	@Before
	public void setup() {
			map = new ListWordMap();
	}
	
	@Test
	public void AddPositionTest() throws WordException {
		map.addPosition(word1, pos1);
		assertEquals(1,map.numberOfEntries());
	}
	
	@Test
	public void MultiplePositionsTest() throws WordException {
		map.addPosition(word1, pos1);
		map.addPosition(word2, pos2);
		assertEquals(2,map.numberOfEntries());
	}
	
	@Test (expected = WordException.class)
	public void RemoveEmptyMapWordAndPositionTest() throws WordException {
		map.removeWord(word1);
		map.removePosition(word1, pos1);
	}
	
	
	
	@Test
	public void RemoveMapPositonTest() throws WordException {
		map.addPosition(word1, pos1);
		assertEquals(1,map.numberOfEntries());
		map.addPosition(word1, pos2);
		map.removePosition(word1,pos1);
		assertEquals(1,map.numberOfEntries());
	}
	
	@Test
	public void RemoveMapWordTest() throws WordException {
		map.addPosition(word1, pos1);
		assertEquals(1,map.numberOfEntries());
		
		map.removeWord(word1);
		assertEquals(0,map.numberOfEntries());
	}
	
	@Test (expected = WordException.class)
	public void EmptyPositionsTest() throws WordException {
		map.positions(word1);
	}
	
	@Test
	public void EmptyWordsTest() throws WordException {
		assertFalse(map.words().hasNext());
	}
	
	@Test
	public void WordTest() {
		map.addPosition(word1, pos1);
		map.addPosition(word2, pos2);
		
		String[] testArray = {word1, word2};
		
		Iterator<String> testIterator = map.words();
		
		int idx = 0;
		while (testIterator.hasNext()) {
			assertEquals(testArray[idx],testIterator.next());
			idx++;
		}
	}
	
	@Test
	public void PositionTest() throws WordException {
		map.addPosition(word1, pos1);
		map.addPosition(word2, pos2);
		map.addPosition(word2, pos3);
		assertTrue(map.positions(word1).hasNext());
		assertTrue(map.positions(word2).hasNext());
		
		Iterator<IPosition> posTest = map.positions(word2);
		assertEquals(pos2,posTest.next());
		assertEquals(pos3,posTest.next());
	}
	
	@Test
	public void wordCounterTest() {
		map.addPosition(word1, pos1);
		map.addPosition(word1, pos2);
		map.addPosition(word2, pos3);
		assertEquals(2, map.wordCounter());
	}
	
	@Test
	public void wordCounterEmptyMapTest() {
		assertEquals(0, map.wordCounter());
	}
}
