package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringRotation {

	public void isRotation(String s1, String s2){
		if(s1 == null && s2 == null){
			System.out.println("True");
			return;
		}

		if(s1 == null)
			return;
		if(s2 == null)
			return;

		String s3 = s1 + s2;
		
		if(s3.contains(s2))
			System.out.println("True");
		else
			System.out.println("False");
			
	}
	public void readInput(String fileName) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = r.readLine()) != null){
			String[] input = line.split(",");
			isRotation(input[0], input[1]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new StringRotation().readInput(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
