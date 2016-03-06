package algo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


// http://www.geeksforgeeks.org/maximum-product-subarray/
public class MaximumSubarrayProduct {

	public static int maxProduct(List<Integer> input){
		int maxProduct = Integer.MIN_VALUE;
		int product = 1;
		
		for(int i = 0 ; i < input.size(); i++){
			product *= input.get(i);
			
			if(maxProduct < product){
				maxProduct = product;
			}
		}
		return maxProduct;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader r = new BufferedReader(new FileReader("data/sumofinteger.txt"));
			String line;
			while ((line = r.readLine()) != null) {
				String [] columns = line.split(",");
				Integer[] input = new Integer[columns.length];
				for(int i=0;i<columns.length;i++){
					input[i] = Integer.parseInt(columns[i].trim());
				}
				System.out.println(maxProduct(Arrays.asList(input)));
			}
	}

}
