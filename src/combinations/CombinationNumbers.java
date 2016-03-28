package combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CombinationNumbers {

	/*
	Given two integers n and k, return all possible combinations of k numbers out of 1...n.

		For example,
		If n = 4 and k = 2, a solution is:

		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
	 */

	public List<List<Integer>> combine(int n, int k) {
		return combine(n, 1, k);
	}

	public List<List<Integer>> combine(int n, int start, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k <= 0) {
			List<Integer> r = new ArrayList<Integer>();
			result.add(r);
			return result;
		}
		for (int i = start; i <= n; i++) {
			List<List<Integer>> newResults = combine(n, i + 1, k - 1);
			for (List<Integer> l1 : newResults) {
				l1.add(i);
				Collections.sort(l1);
			}
			result.addAll(newResults);
		}
		return result;
	}
	/*
	 * Given a set of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.

		The same repeated number may be chosen from C unlimited number of times.
		Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
		The solution set must not contain duplicate combinations.
		
		For example, 
		given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] 
	 */

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> current = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, current, result);
		return result;
	}

	public void combinationSum(int[] candidates, int target, int start,
			ArrayList<Integer> cur, List<List<Integer>> result) {
		if (target == 0) {
			ArrayList<Integer> r = new ArrayList<Integer>(cur);
			result.add(r);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			cur.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	/*
		Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

		Each number in C may only be used once in the combination.
		Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
		The solution set must not contain duplicate combinations.
		For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
		A solution set is: 
		[1, 7] 
		[1, 2, 5] 
		[2, 6] 
		[1, 1, 6] 
	 */

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<Integer> current = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		HashSet<List<Integer>> resultSet = new HashSet<List<Integer>>();
		combinationSum2(candidates, target, 0, current, resultSet);
		result.addAll(resultSet);
		return result;
	}

	public void combinationSum2(int[] candidates, int target, int start,
			ArrayList<Integer> curr, HashSet<List<Integer>> result) {
		if (target == 0) {
			ArrayList<Integer> r = new ArrayList<Integer>(curr);
			result.add(r);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			curr.add(candidates[i]);
			combinationSum2(candidates, target - candidates[i], i + 1, curr,
					result);
			curr.remove(curr.size() - 1);
		}
	}

	/*
	 *	Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
		Ensure that numbers within the set are sorted in ascending order.

		Example 1:
		Input: k = 3, n = 7
		Output:
		[[1,2,4]]

		Example 2:
		Input: k = 3, n = 9
		Output:
		
		[[1,2,6], [1,3,5], [2,3,4]]
	 */

	public List<List<Integer>> combinationSum3(int k, int n) {
		ArrayList<Integer> cur = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum3(n, k, 1, cur, result);
		return result;
	}

	public void combinationSum3(int target, int kNumbers, int start,
			ArrayList<Integer> current, List<List<Integer>> result) {
		if (target == 0) {
			if (current.size() == kNumbers) {
				ArrayList<Integer> r = new ArrayList<Integer>(current);
				result.add(r);
			}
			return;
		}
		for (int i = start; i <= 9; i++) {
			if (target < i)
				return;
			current.add(i);
			combinationSum3(target - i, kNumbers, i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}
}