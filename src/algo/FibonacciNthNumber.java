package algo;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciNthNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String first = input.next();
        String second = input.next();
        
        int nth = input.nextInt();
        
        BigInteger[] temp = new BigInteger[nth];
        temp[0]= new BigInteger(first);
        temp[1]=new BigInteger(second);

        for(int i=2;i < nth;i++){
            temp[i] = temp[i-1].multiply(temp[i-1]).add(temp[i-2]);
        }
        System.out.println(temp[nth-1]);
        
    }
}