package dynamic_programming;

public class LongestCommonSubsequence {
	
	
	/* A Naive recursive implementation of LCS problem 
	 *  Time Complexity: O(2^n) in worst case
	 */
	static int lcs(String s1, String s2, int s1Index, int s2Index ){
		if(s1Index==0 || s2Index==0){
			return 0;
		}
		if(s1.charAt(s1Index-1) == s2.charAt(s2Index-1)){
			return 1 + lcs( s1, s2, s1Index-1, s2Index-1);
		} else
			return Math.max(lcs(s1,s2, s1Index-1, s2Index), lcs(s1,s2, s1Index, s2Index-1));
	}
	
	/* 
	 * Dynamic Programming Implementation
	 * Time Complexity: O(mn) in worst case
	 */ 
	
	static int lcsDP(String s1, String s2){

		int[][] lcs = new int[s1.length()+1][s2.length()+2];

		for(int i=0; i <=s1.length(); i++){
			for(int j=0; j<= s2.length(); j++){
				if(i==0 || j==0){
					lcs[i][j] =0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					lcs[i][j] = 1 + lcs[i-1][j-1];
				} else{
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		// Print the LCS
		int i=s1.length(), j=s2.length();
		while(i>0 && j>0){
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				System.out.print(s1.charAt(i-1));
				i--;j--;
			} else {
				if( lcs[i-1][j] > lcs[i][j-1])
					i--;
				else
					j--;
			}
			
		}
	
		return lcs[s1.length()][s2.length()];
	}
	
	
	
	public static void main(String [] args){
		String s1= "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(LongestCommonSubsequence.lcs(s1, s2, s1.length(), s2.length()));
		System.out.println(LongestCommonSubsequence.lcsDP(s1, s2));
	}
}
