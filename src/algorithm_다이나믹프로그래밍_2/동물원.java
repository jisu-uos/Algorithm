package algorithm_다이나믹프로그래밍_2;

import java.util.Scanner;

public class 동물원 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int div = 9901;
		int max[][] = new int[n+1][3];

		max[0][0] = 1;
		for(int i=1; i<=n; i++) {
			max[i][0] = (max[i-1][0] + max[i-1][1] + max[i-1][2])%div;
			max[i][1] = (max[i-1][0] + max[i-1][1])%div;
			max[i][2] = (max[i-1][0] + max[i-1][2])%div;
		}
		
		System.out.print((max[n][0]+max[n][1]+max[n][2])%div);
	}

}
