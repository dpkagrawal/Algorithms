package combinations;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	static void combination(ArrayList<Integer> numbers, int start, ArrayList<Integer> current, List<ArrayList<Integer>> result, int k) {
	
		if(k <= 0){
			ArrayList<Integer> r = new ArrayList<Integer>();
			r.addAll(current);
			result.add(r);
			return;
		}
		
		for(int i=start; i< numbers.size();i++ ){
			current.add(numbers.get(i));
			combination(numbers, i+1, current, result, k-1);
			current.remove(current.size()-1);
		}
	}
	
	static void printCombinations(List<ArrayList<Integer>> combinations ){
		for(ArrayList<Integer> c: combinations){
			for(Integer i: c){
				System.out.print(i +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args){
		ArrayList<Integer> input = new ArrayList<Integer>() ;
		input.add(1);
		input.add(2);
		input.add(3);
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		Combination.combination(input, 0, new ArrayList<Integer>(), result, 3);
		System.out.println(result);
	}
}
