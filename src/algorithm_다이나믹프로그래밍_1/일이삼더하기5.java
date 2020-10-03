//시간 초과

package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 일이삼더하기5 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int div = 1000000009;
		int cnt = sc.nextInt();
		
		for(int k=0; k<cnt; k++ ){
			int n = sc.nextInt();
			int m = Math.max(n, 3);
			int[][] plus = new int[m+1][4];
						
			plus[1][1] = plus[2][2] = plus[3][3] = plus[3][1] = plus[3][2] = 1;
			for(int i=4; i<=n;i++) {
				plus[i][1] = (plus[i-1][2] + plus[i-1][3])%div;
				plus[i][2] = (plus[i-2][1] + plus[i-2][3])%div;
				plus[i][3] = (plus[i-3][1] + plus[i-3][2])%div;							
			}			
			
			System.out.println((plus[n][1]+plus[n][2]+plus[n][3])%div);		
		}
		
	}
}
