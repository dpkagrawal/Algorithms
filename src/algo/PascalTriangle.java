package algo;

import java.util.ArrayList;
import java.util.List;
/*
 	Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return

	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
 */

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return result;
		List<Integer> first = new ArrayList<Integer>();
		first.add(1);
		result.add(first);
		for (int i = 1; i < numRows; i++) {
			List<Integer> previous = result.get(i - 1);
			List<Integer> curr = new ArrayList<Integer>();
			curr.add(previous.get(0));
			int previousEl = previous.get(0);
			for (int j = 1; j < previous.size(); j++) {
				curr.add(previousEl + previous.get(j));
				previousEl = previous.get(j);
			}
			curr.add(previous.get(previous.size() - 1));
			result.add(curr);
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(PascalTriangle.generate(5));
	}
}
