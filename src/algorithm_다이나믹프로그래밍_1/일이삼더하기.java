package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 일이삼더하기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		for(int j=0; j<cnt; j++ ){
			int n = sc.nextInt();
			
			int[] plus = new int[n+1];

			plus[0] = 1;
			plus[1] = 1;
			
			if(n>1)
				plus[2] = 2;
			
			for(int i=3; i<=n;i++) {
				plus[i] = plus[i-3]+plus[i-2]+plus[i-1];
			}			
			
			System.out.println(plus[n]);		
		}
		
	}
}
