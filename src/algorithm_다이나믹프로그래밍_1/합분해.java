package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 합분해 {

	 public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		 
		 int n = sc.nextInt();
		 int k = sc.nextInt();
		 int a = n+k-1;
		 int b = k-1;
		 int arr[][] = new int[a+1][a+1];
		 				 
		 for(int i=1; i<=a; i++) {
			 for(int j=0; j<=i; j++) {
				 if(i==j || j==0)
					 arr[i][j] = 1;
				 else {
					 arr[i][j] = (arr[i-1][j-1] + arr[i-1][j])%1000000000;
				 }
			 }			 
		 }
		 
		 System.out.print(arr[a][b]);
	 }
}
