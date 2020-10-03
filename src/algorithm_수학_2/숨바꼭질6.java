package algorithm_수학_2;

import java.util.Scanner;

public class 숨바꼭질6 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int s = sc.nextInt();
		 int[] sis = new int[n];
		 int ans = 0;
		 
		 for(int i=0; i<n; i++) {
			 int x = sc.nextInt();
			 if(x > s)
				 sis[i] = x-s;
			 else
				 sis[i] = s-x;
		 }
		 
		 ans = sis[0];
		 for(int i=1; i<n; i++) {
			 ans = gcd(ans,sis[i]);
		 }
		 
		 System.out.print(ans);	 
	 	 
	}
	
	public static int gcd(int m, int n) {
		return n == 0 ? m : gcd(n,m%n);
	}
}
		 
