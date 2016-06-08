package combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Input:  array: [q1,q2,q3] sample set size: 2
 * Output: [[q1,q2], [q1,q3], [q1,q1], [q2,q3], [q2, q3], [q3,q3]]
 * Company : UBER 
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
//			System.out.println(newResults);
			result.addAll(newResults);
		}

		return result;
	}
	
	static public void printVariants2(List<String> input, int start,int k, List<String> current, List<ArrayList<String>> result){
		if(k<=0){
			ArrayList<String> r = new ArrayList<String>(current);
			result.add(r);
			return;
		}

		for(int i=start; i<input.size();i++){
			current.add(input.get(i));
			printVariants2(input, i, k-1, current, result);
			current.remove(current.size()-1);
		}
	}

	public static void main(String []args){
		List<String> input = new ArrayList<String>(Arrays.asList("q1", "q2"));
		int k =2;
		List<ArrayList<String>> result = SampleSet.printVariants(input, 0, k);
		System.out.println(result.size());
		print(result);
		result.clear();
		printVariants2(input, 0, k, new ArrayList<String>(), result);
		System.out.println("/nMethod 2");
		print(result);
	}

	private static void print(List<ArrayList<String>> result) {
		for(int i=0;i< result.size();i++){
			List<String> temp = result.get(i);
			for(int j=0; j < temp.size();j++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}