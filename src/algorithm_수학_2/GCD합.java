package algorithm_¼öÇÐ_2;

import java.util.Scanner;

public class GCDÇÕ {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();

		 while(n>0) {
			 int m = sc.nextInt();
			 int[] arr = new int[m];
			 for(int i=0; i<m; i++) {
				 arr[i] = sc.nextInt();
			 }
			 long sum = 0;
			 for(int i=0; i<m-1;i++) {
				 for(int j=i+1;j<m;j++) {
					 sum += gcd(arr[i],arr[j]);
				 }
			 } 		
			 System.out.println(sum);
			 n--;
		 }		 	 
	}
	
	public static int gcd(int m, int n) {
		return n == 0 ? m : gcd(n,m%n);
	}
}
		 
