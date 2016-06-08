package dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 	https://en.wikipedia.org/wiki/Knapsack_problem
 *  https://www.youtube.com/watch?v=8LusJS5-AGo
 */
public class Knapsack {
	class Item {
		int weight;
		int value;

		Item(int w, int v) {
			weight = w;
			value = v;
		}
	}

	List<Item> items = new ArrayList<Item>();
	int sizeOfBag;

	public void solveKnapsackProblem() {
		// row-columns
		int numberOfItems = items.size();
		int[][] dp = new int[numberOfItems + 1][sizeOfBag + 1];
		// item is row
		// weight is column
		for (int item = 0; item <= numberOfItems; item++) {
			for (int weight = 0; weight <= sizeOfBag; weight++) {
				if (weight == 0 || item == 0) {
					dp[item][weight] = 0;
				} else if (items.get(item - 1).weight > weight) {
					dp[item][weight] = dp[item - 1][weight];
				} else if (item == 1) {
					Item currItem = items.get(item - 1);
					dp[item][weight] = currItem.value;
				} else {
					Item currItem = items.get(item - 1);
					int remainderWeight = weight - currItem.weight;
					int previousItem = item - 1;
					// System.out.println("currItem.weight "+ currItem.weight +
					// " weight: "+ weight);
					// System.out.println("remainderWeight: " + remainderWeight
					// +" previousItem" + previousItem );
					int newValueInclusive = currItem.value
							+ dp[previousItem][remainderWeight];
					int excludingCurrentItem = dp[previousItem][weight];
					// System.out.println("item: " + item + " weight:" +
					// weight);
					// System.out.println("newValueInclusive: " +
					// newValueInclusive + " excludingCurrentItem: "+
					// excludingCurrentItem);
					dp[item][weight] = Math.max(newValueInclusive,
							excludingCurrentItem);
				}
			}
		}
		System.out.println(dp[numberOfItems][sizeOfBag]);
	}

	public static void main(String[] args) {
		Knapsack s = new Knapsack();
		s.sizeOfBag = 7;
		s.items.add(s.new Item(1, 1));
		s.items.add(s.new Item(3, 4));
		s.items.add(s.new Item(4, 5));
		s.items.add(s.new Item(7, 6));
		s.solveKnapsackProblem();
	}
}