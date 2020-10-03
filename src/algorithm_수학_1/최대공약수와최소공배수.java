package algorithm_수학_1;

import java.util.Scanner;

public class 최대공약수와최소공배수 {
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 long num1 = sc.nextLong();
	     long num2 = sc.nextLong();
	     
	     long small = uclid(num1, num2);
	     System.out.println(small);
	     System.out.println(num1*num2/small);       	    

	}
	
	public static long uclid(long a, long b) {		
		if(a%b == 0)
			return  b;
		else if (b%a == 0)
			return a;
		else {
			if(a>b)
				return uclid(b,a%b);
			else
				return uclid(a,b%a);
		}
	}
}