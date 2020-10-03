package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 쉬운계단수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long stair[][] = new long[n+1][10];
		long sum = 0;		
		
		stair[1][0] = 0;
		for(int j=1; j<10; j++) {
			stair[1][j]=1;
		}
		
		for(int i=2; i<=n; i++) {
			stair[i][0] = stair[i-1][1];
			stair[i][9] = stair[i-1][8];
			
			for(int j=1; j<9; j++) {
				stair[i][j] = (stair[i-1][j-1] + stair[i-1][j+1])%1000000000;
			}
		}
		
		for(int j=0; j<10; j++) {
			sum += stair[n][j];
		}
		
		System.out.println(sum%1000000000);
	}

}
