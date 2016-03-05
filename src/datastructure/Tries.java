package datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class Tries {

	char data;
	Tries[] nodeValues ;
	boolean isWord=false;
	int count=1;

	Tries(){
		nodeValues = new Tries[26];
		Arrays.fill(nodeValues, null);
	}

	 boolean contains(int index, char c){
		 if(nodeValues[index]!=null && nodeValues[index].data==c){
			 return true;
		 }
		return false;
	}

	 Tries getKey(int index){
		 return this.nodeValues[index];
	 }

	 void insert(String input){
		if(input!=null){
			Tries current = this;
			char[] arr = input.toCharArray();
			for(int i=0;i< arr.length;i++){
				int index = (int) arr[i] %97;
				if(current.contains(index, arr[i])){
					current = current.getKey(index);
					current.count++;
				} else {
					Tries t = new Tries();
					t.data = arr[i];
					if(i== arr.length-1)
						t.isWord=true;
					else
						t.isWord=false;
					current.nodeValues[index]= t;
					current=t;
				}
			}
		}
	 }

	void find(String input){
		char[] arr = input.toCharArray();
		Tries current = this;
		for(int i=0; i< arr.length;i++){
			int index = (int) arr[i] %97;
			if(current.contains(index, arr[i])){
				current = current.getKey(index);
			} else{
				current= null;
				break;
			}
		}
		
		if(current==null){
			System.out.println(0);
		} else
			System.out.println(current.count);
	}
	


    public static void main(String[] args) {
        Tries t = new Tries();
        Scanner input = new Scanner(System.in);
        int numberOfInput = input.nextInt();
        for(int i=0;i< numberOfInput; i++){
        	String operation = input.next();
        	String inputString = input.next();
        	switch(operation) {
        		case "add":
        			t.insert(inputString);
        			break;
        		case "find":
        			t.find(inputString);
        			break;
        		default:
        			System.out.println("Invalid");
        	}
        }
        input.close();
        
    }
}