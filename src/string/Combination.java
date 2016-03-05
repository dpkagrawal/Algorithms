package string;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	static void combination(ArrayList<Integer> numbers) {
		List<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		combinations.add(new ArrayList<Integer>());
		for (int i = 0; i < numbers.size(); i++) {
			List<ArrayList<Integer>> newCombinations = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < combinations.size(); j++) {
				ArrayList<Integer> newComb = new ArrayList<Integer>();
				newComb.addAll(combinations.get(j));
				newComb.add(numbers.get(i));
				newCombinations.add(newComb);
			}
			
			combinations.addAll(newCombinations);
		}
		
		printCombinations(combinations);
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
		Combination.combination(input);
	}
}
