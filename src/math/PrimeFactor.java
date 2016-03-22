package math;


public class PrimeFactor {
	public static void printFactor(int n) {
		if (n < 0)
			return;
		if (n == 1 || n == 2 || n == 3) {
			System.out.println("Primefactors of " + n + ":");
			System.out.println(n);
			return;
		}
		int copyOfN = n;
		 System.out.println("Primefactors of " + n + ":");
		for (int i = 2; i <= copyOfN; i++) {
			while (copyOfN % i == 0) {
				System.out.print(i +" ");
				copyOfN = copyOfN / i;
			}
		}
		System.out.println();
	}
	

	
	public static void main(String[] args){
		PrimeFactor.printFactor(5);
		PrimeFactor.printFactor(15);
		PrimeFactor.printFactor(16);
		PrimeFactor.printFactor(10);
		PrimeFactor.printFactor(25);
	}
}
