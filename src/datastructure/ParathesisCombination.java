package datastructure;


public class ParathesisCombination {
	static void process(int numberOfParentheis) {
		process("", numberOfParentheis, 0, 0);
	}

	static void  process(String value, int n, int open, int close) {
		if (close == n && open==n) {
			System.out.println(value);
			return;
		} else {
			if(open < n){
				process(value + "{", n, open+1, close);
			}
			if (open > close) {
				process(value + "}", n, open, close + 1);
			}
			
		}
	}
	
	public static void main(String [] args){
		ParathesisCombination.process(2);
	}
}
