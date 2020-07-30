package hackerrank.hashmaps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class RansomNoteTest {
	
	@Test
	public void test1() {
		String[] magazine = new String[] {"a", "A", "ransom", "Ransom", "note"};
		String[] note = new String[] {"a", "Ransom", "note"};
		
		assertTrue(RansomNote.checkMagazineImpl(magazine, note));
	}

	@Test
	public void test2() {
		String[] magazine = new String[] {"A", "ransom", "Ransom", "note"};
		String[] note = new String[] {"a", "Ransom", "note", "a"};
		
		assertFalse(RansomNote.checkMagazineImpl(magazine, note));
	}
	
	@Test
	public void test3() {
		String[] magazine = new String[] {"a", "A", "ransom", "note", "is"};
		String[] note = new String[] {"a", "Ransom", "note", "is", "a", "note"};
		
		assertFalse(RansomNote.checkMagazineImpl(magazine, note));
	}

}
