package exercises.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetOfStacks should be composed of several stacks and should
 * create a new stack once the previous one exceeds capacity. SetOfStacks.push()
 * and SetOfStacks.pop() should behave identically to a single stack (that is,
 * pop() should return the same values as it would if there were just a single
 * stack).

 * A Stack is LIFO (last in first out)
 * 
 * Example: threshold = 5 
 * In => A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M -> N 
 * 		S0 = E -> D -> C -> B -> A 
 * 		S1 = J -> I -> H -> G -> F 
 * 		S2 = N -> M -> L -> K
 * 
 * Output => N -> M -> L -> K -> J -> I -> H -> G -> F -> E -> D -> C -> B -> A
 * 
 * In => A -> B -> /pop/ C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M -> N 
 * 		S0 = F -> E -> D -> C -> A 
 * 		S1 = K -> J -> I -> H -> G 
 * 		S2 = N -> M -> L
 * Output => N -> M -> L -> K -> J -> I -> H -> G -> F -> E -> D -> C -> A
 * 
 * 
 * Implementation: 
 * - List of Stacks 
 * - Need to maintain {currentIndexInList, currentCountInListPosition} 
 * - Push => control currentCountInListPosition <= threshold update currentCountInListPosition update currentIndexInList if needed (new stack) 
 * - Pop => list[currentIndexInList].pop() control = list[currentIndexInList].isEmpty() => true decrease currentIndexInList (control always => 0) decrease currentCountInListPosition
 *
 */
public class StackExercise3 {
	
	public static class SetOfStacks<T> {

		private List<JStack<T>> mStackList = new ArrayList<JStack<T>>();
		private int mCurrentIndexInList = 0;
		private int mCurrentCountInListPosition = 0;
		private int mThreshold;

		public SetOfStacks(int threshold) {
			mThreshold = threshold;
		}

		public void push(T item) {
			int indexToUse = mCurrentIndexInList;
			
			
			if (mCurrentCountInListPosition == mThreshold) {
				indexToUse = indexToUse + 1;
				mCurrentIndexInList = indexToUse;
				mCurrentCountInListPosition = 0;
			}
			
			if (indexToUse == mStackList.size()) {
				mStackList.add(new JStack<T>());
			}

			mStackList.get(indexToUse).push(item);
			mCurrentCountInListPosition = mCurrentCountInListPosition + 1;
		}

		public T pop() {
			if (isEmpty()) {
				throw new IllegalStateException("The stack is empty");
			}

			if (mStackList.get(mCurrentIndexInList).isEmpty()) {
				mStackList.remove(mCurrentIndexInList);
				mCurrentIndexInList = mCurrentIndexInList - 1;
				mCurrentCountInListPosition = mThreshold;
			}

			T toPop = mStackList.get(mCurrentIndexInList).pop();
			mCurrentCountInListPosition = mCurrentCountInListPosition - 1;
			return toPop;
		}

		public boolean isEmpty() {
			return mStackList.get(mCurrentIndexInList).isEmpty() && mCurrentIndexInList == 0;
		}

		public T peek() {
			if (isEmpty()) {
				throw new IllegalStateException("The stack is empty");
			}

			return mStackList.get(mCurrentIndexInList).peek();
		}
	}
}
