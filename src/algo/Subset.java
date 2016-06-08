package algo;

import java.util.ArrayList;

public class Subset {

	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); // O(n)
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	public void getSubsetsUsingBinary(ArrayList<Integer> input) {
		int powerSetSize = (int) Math.pow(2, input.size());

		for (int counter = 0; counter < powerSetSize; counter++) {
			for (int j = 0; j < input.size(); j++) {
				if ((counter & 1 << j) != 0)
					System.out.print(input.get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Subset s = new Subset();

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		ArrayList<ArrayList<Integer>> a1 = s.getSubsets(a, 0);
		System.out.println(a1.toString());
		s.getSubsetsUsingBinary(a);
	}
}
