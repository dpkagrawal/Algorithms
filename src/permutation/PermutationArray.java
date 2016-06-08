package permutation;

import java.util.ArrayList;

public class PermutationArray {
	
	public static void permute(ArrayList<Integer> nums){

		ArrayList<ArrayList<Integer>> results  = new ArrayList<ArrayList<Integer>>();

		results.add(new ArrayList<Integer>());

		for(Integer num : nums){
			for(ArrayList<Integer> res : results){
				for(int i=0;i< res.size();i++){
					
				}
			}
		}


	}
	public static void main(String[] args){
		
	}
}
