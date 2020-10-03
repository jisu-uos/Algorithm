package algorithm_다이나믹프로그래밍_2;

import java.io.*;

public class 타일채우기 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int max[][] = new int[n+1][3];
		
		max[1][0]=1;
		if(n>1)
			max[2][1]=2;
		for(int i=3; i<=n; i++) {
			max[i][0] = 3*max[i-2][0]+max[i-2][2];
			max[i][1] = max[i-1][2] + 2*max[i-1][0];
			max[i][2] = max[i-1][1];
		}

		System.out.println(3*max[n-1][0]+max[n-1][2]);					
	}

}
