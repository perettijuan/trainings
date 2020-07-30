package hackerrank.hashmaps;

import java.util.HashMap;

/*
 * Examples:
 *   Input = magazine [a, A, ransom, Ransom, note]
 *           note [a Ransom note]
 *   Output = YES
 *   
 *   Input = magazine [A, ransom, Ransom, note]
 *           note [A Ransom note a]
 *   Output = NO
 *   
 *   Input = magazine [a, A, ransom, note, is]
 *           note [A ransom note is a note]
 *   Output = NO (note is twice in the note)
 *   
 *   
 *   
 * Algorithm:
 *  1 - Iterate the magazine and store it in a HashMap (key = word, value = number of times).
 *  2 - Iterate the note and check if key is present, count down (if value becomes zero = remove).
 *  
 *  
 *  Question: HashMap.containsKey() is case sensitive? ==> ANSWER = YES 
 *  
 *  
 *  TIME: 25 minutes
 */
public class RansomNote {

	static void checkMagazine(String[] magazine, String[] note) {
		boolean canCreate = checkMagazineImpl(magazine, note);
		
		if (canCreate) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
    }
	
	
	static boolean checkMagazineImpl(String[] magazine, String[] note) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		boolean canCreate = true;
		
		//magazine [a, A, ransom, Ransom, note]
		//note [a Ransom note]
		for (String word : magazine) { // word = note
			if (map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count + 1);
			} else {
				map.put(word, 1); // [a -> 1, A -> 1, ransom -> 1, Ransom -> 1, note -> 1] 
			}
		}
		
		for (String wordInNot : note) { // wordInNote = note
			if (map.containsKey(wordInNot)) {
				int updatedCount = map.get(wordInNot) - 1; // updatedCount = 0
				if (updatedCount == 0) {
					map.remove(wordInNot); // [A -> 1, ransom -> 1]
				} else {
					map.put(wordInNot, updatedCount);
				}
			} else {
				canCreate = false;
			}
		}
		return canCreate;
	}
}
