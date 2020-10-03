package algorithm_다이나믹프로그래밍_2;

import java.util.*;
import java.io.*;

public class 정수삼각형 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num[][] = new int[n+1][n+1];
		int max[][] = new int[n+1][n+1];
		int result = 0;
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			max[i][1] = max[i-1][1] + num[i][1];
			max[i][i] = max[i-1][i-1] + num[i][i];		
			for(int j=2; j<i; j++) {
				max[i][j] = Math.max(max[i-1][j-1], max[i-1][j]) + num[i][j];	
			}
		}
		
		for(int i=1; i<=n; i++)
			result = result > max[n][i] ? result : max[n][i];
		
		System.out.print(result);		
		
	}
}
