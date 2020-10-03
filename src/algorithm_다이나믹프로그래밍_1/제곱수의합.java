package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 제곱수의합 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] twice = new int[n+1];
		
		int root = 1;
		
		while(root*root<=n)
			root++;
		root--;
		
		twice[0] = 0;
		twice[1] = 1;
		
		for(int i=2; i<=n; i++) {
			int now = 0;
			twice[i] = i;
			for(int j=1; i-j*j>=0 ; j++) {
				now = twice[i-j*j] + 1;
				twice[i] = Math.min(twice[i], now);
			}
		}

		System.out.println(twice[n]);
		
	}
}
