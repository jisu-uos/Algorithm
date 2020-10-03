package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 타일링 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] tile = new int[n+1];
		
		tile[0] = 1;
		tile[1] = 1;
		for(int i =2; i<=n; i++) {
			tile[i] = tile[i-1] + tile[i-2];
			tile[i] %= 10007;
		}		

		System.out.print(tile[n]);
	}
}
