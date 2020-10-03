package algorithm_다이나믹프로그래밍_2;

import java.io.*;

public class 오르막수 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ascending[][] = new int[n+1][10];
		int sum = 0;
		int div = 10007;
		
		
		ascending[0][0] = 1;
		
		for(int i=1; i<=n; i++) {
			ascending[i][0] = ascending[i-1][0];
			for(int j=1; j<10; j++)
				ascending[i][j] = (ascending[i][j-1] + ascending[i-1][j])%div;
		}
		
		for(int i=0; i<10; i++)
			sum += ascending[n][i];
		
		System.out.print(sum%div);
	}
}
