package hackerrank.greedy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreedyFloritsTest {

//	@Test
//	public void test1() {
//		int k = 3;
//		int[] c = { 1, 2, 3, 4 };
//		int expected = 11;
//		int actual = GreedyFlorits.getMinimumCost(k, c);
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void test2() {
//		int k = 3;
//		int[] c = { 2, 5, 6 };
//		int expected = 13;
//		int actual = GreedyFlorits.getMinimumCost(k, c);
//
//		assertEquals(expected, actual);
//	}

	@Test
	public void test3() {
		int k = 3;
		int[] c = { 390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985,
				132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277,
				959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028,
				642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800 };
		int expected = 163578911;
		int actual = GreedyFlorits.getMinimumCost(k, c);

		assertEquals(expected, actual);
	}
}
