package hackerrank.challenges;

import java.io.*;
import java.util.*;

/*
 * M = 2
 * List = 5 2 1 8
 * O = 1
 * 
 * M = 4
 * List = 10 200 3 40000 5
 * O = 4 
 * 
 * M = 2
 * List = 42
 * O = Nil
 *
 * M = 3
 * List = 1 7 6
 * O = 1
 * 
 * M = 7
 * List = 1 7 6 5 8 3 10 87 1000 76
 * O = 6
 * 
 * Item to return = list.length - M // list.lenght starts at 1
 * 
 * 1 - Iterate the list and count using a counter (counter starts at 1).
 * 2 - Have a HashMap key = counter, value = node
 * 3 - When done, calculate counter - M = value in hashMap
 * 4 - Get from HasMap
 *
 *
 * SOLVED (TIME OUT)
 * ********************************** TOOK ME 45 MIN APROX **********************************************
 */
public class MToLastElement {

	/*
	 * This is the code to read the input for:
	 * https://www.hackerrank.com/contests/programming-interview-questions/
	 * challenges/m-th-to-last-element
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();

			int m = Integer.parseInt(line);
			List<Integer> input = new ArrayList<Integer>();

			StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
			while (tokenizer.hasMoreTokens()) {
				input.add(Integer.parseInt(tokenizer.nextToken()));
			}

			// these two are the inputs
			System.out.println("m = " + m);
			System.out.println("input = " + input.toString());

			// this is the output
			System.out.println("9");
			
			KNode head = new KNode(input.get(0));
			KNode current = head;
			for (int i = 1; i < input.size(); i++) {
				if (current == null) {
					break;
				}
				current.mNext = new KNode(input.get(i));
				current = current.mNext;
			}

			int outPut = findMToLastelement(head, m);
			System.out.println(outPut);

		} catch (Exception e) {

		}

	}

	public static int findMToLastelement(KNode head, int m) { // 10 200 3 40000 5, M = 4
		int counter = 0;
		HashMap<Integer, KNode> map = new HashMap<Integer, MToLastElement.KNode>();
		
		KNode current = head; //current = 200
		while (current != null) { 
			counter = counter + 1; // counter = 2
			map.put(counter, current); // map = [1, 10]
			current = current.mNext; // current = 200
		}
		
		int positionNode = (counter + 1) - m; // 4 - 2 = 2
		
		if (positionNode <= 0) {
			return -1;
		} else {
			return map.get(positionNode).mValue;
		}
	}
	
	
	
	public static class KNode {
		public KNode mNext;
		public int mValue;
		
		public KNode(int value) {
			mValue = value;
		}
	}

}
