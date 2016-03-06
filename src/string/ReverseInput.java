package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReverseInput {

	public void reverseAnInput(String fileName) throws IOException{
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		String line;
		while((line = r.readLine()) != null)
			if(line.length() > 0)
				System.out.println(reverseWords(line));
	}
	
	public String reverseWords(String line){
		if(line == null || line.isEmpty())
			return "";
		String[] strArr = line.split(" ");
		
		StringBuffer result = new StringBuffer();
		int len = strArr.length - 1;
		while(len >= 0){
			result.append(strArr[len] + " ");
			len--;
		}
		return result.toString().trim();
	}
	
	public static void main(String[] args){
		try {
			new ReverseInput().reverseAnInput(args[0]);
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
	}
}
