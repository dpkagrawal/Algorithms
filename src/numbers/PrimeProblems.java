package numbers;
public class PrimeProblems {

	private boolean isPrime(Integer num) {
		if (num == 0 || num == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private boolean isPalindrome(String str) {
		if (str == null || str.isEmpty())
			return false;
		int s = 0;
		int e = str.length() - 1;
		while (s < e) {
			if (str.charAt(s) != str.charAt(e))
				return false;
			s++;
			e--;
		}
		return true;
	}

	public void printPrimePalindrom(int n) {
		int maxPrimePalindrome = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				if (isPalindrome(Integer.toString(i))){
					if(maxPrimePalindrome < i)
						maxPrimePalindrome = i;
				}
					
			}

		}
	System.out.println(maxPrimePalindrome);
	}
	
	
	public void sumofPrimes(){
		int sumOfPrimes = 0;
		int primeCount = 0;
		int i = 2;
		while(primeCount < 1000) {
			if (isPrime(i)) {
				sumOfPrimes += i;
				primeCount++;
			}
			i++;
		}
	System.out.println(sumOfPrimes);
	}

	public static void main(String[] args) {
		new PrimeProblems().sumofPrimes();
	}

}
