package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * 
 * Input:  array: [q1,q2,q3] sample set size: 2
 * Output: [[q1,q2], [q1,q3], [q1,q1], [q2,q3], [q2, q3], [q3,q3]]
 * 
 * 
 */
public class SampleSet {
	
	static public List<ArrayList<String>> printVariants(List<String> input, int start, int sampleSize){
		List<ArrayList<String>> result = new  ArrayList<ArrayList<String>>();
		if(sampleSize <=0){
			result.add(new ArrayList<String>());
			return  result;
		}

		 for(int i=start;i< input.size();i++){
			 List<ArrayList<String>> newResults = printVariants(input, i, sampleSize-1);
			 
			 for(int j=0;j< newResults.size();j++){
				 newResults.get(j).add(input.get(i));
			 }
			 result.addAll(newResults);
		 }
		 
		 return result;
	}
	
	
	public static void main(String []args){
		List<String> input = new ArrayList<String>(Arrays.asList("q1", "q2"));
		List<ArrayList<String>> result = SampleSet.printVariants(input, 0, 3);
		System.out.println(result.size());
		for(int i=0;i< result.size();i++){
			List<String> temp = result.get(i);
			for(int j=0; j < temp.size();j++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}
