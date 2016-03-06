package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumOfInteger {
	static void process(int[] values) {
		int max = Integer.MIN_VALUE;
		int nonContMax = Integer.MIN_VALUE;
		int currentMax = 0;
		boolean allNegative = true;
		int positiveSum = 0;
		int minimum = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++) {
			currentMax += values[i];
			if (max < currentMax) {
				max = currentMax;
			}
			if (currentMax < 0) {
				currentMax = 0;
			}
			if (values[i] > 0) {
				positiveSum += values[i];
				allNegative = false;
			}
			if (allNegative && values[i] > minimum) {
				minimum = values[i];
			}
		}
		System.out.print("Continuous Max :"+ max + " ");
		if (allNegative)
			System.out.println("Non-Continuous Max :" + minimum);
		else
			System.out.println("Non-Continuous Max :" + positiveSum);
	}

	public void readInput(String fileName) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = r.readLine()) != null) {
			String [] columns = line.split(",");
			int[] input = new int[columns.length];
			for(int i=0;i<columns.length;i++){
				input[i] = Integer.parseInt(columns[i].trim());
			}
			process(input);
		}
	}
	public static void main(String[] args) {
		try {
			new SumOfInteger().readInput("data/sumofinteger.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
