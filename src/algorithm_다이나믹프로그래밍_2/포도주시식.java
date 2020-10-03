package algorithm_다이나믹프로그래밍_2;

import java.io.*;

public class 포도주시식 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mount[] = new int[n+1];
		int max[][] = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			mount[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=n; i++) {
			max[i][0] = max_3(max[i-1][0],max[i-1][1],max[i-1][2]);
			max[i][1] = max[i-1][0] + mount[i];
			max[i][2] = max[i-1][1] + mount[i];
		}
		
		System.out.print(max_3(max[n][0],max[n][1],max[n][2]));
	}
	
	public static int max_3(int a,int b,int c) {
		int s;
		s = a>b ? a : b;
		s = s>c ? s : c;
		return s;
	}
}
