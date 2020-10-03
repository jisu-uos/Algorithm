package algorithm_다이나믹프로그래밍_2;

import java.io.*;
import java.util.*;

public class RGB거리2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt= Integer.parseInt(br.readLine());
		int price[][] = new int[cnt+1][3];
		int min[][] = new int[cnt+1][3];
		int ans[] = new int[3];
		
		for(int i=1; i<=cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
				price[i][j] = Integer.parseInt(st.nextToken());
		}

		min[2][0] = 10000000;
		min[2][1] = price[1][0] + price[2][1];
		min[2][2] = price[1][0] + price[2][2];		
		for(int i=3; i<=cnt; i++) {
			min[i][0] = Math.min(min[i-1][1], min[i-1][2]) + price[i][0];
			min[i][1] = Math.min(min[i-1][0], min[i-1][2]) + price[i][1];
			min[i][2] = Math.min(min[i-1][0], min[i-1][1]) + price[i][2];
		}
		ans[0] = Math.min(min[cnt][1], min[cnt][2]);
		
		min[2][0] = price[1][1] + price[2][0];
		min[2][1] = 10000000;
		min[2][2] = price[1][1] + price[2][2];		
		for(int i=3; i<=cnt; i++) {
			min[i][0] = Math.min(min[i-1][1], min[i-1][2]) + price[i][0];
			min[i][1] = Math.min(min[i-1][0], min[i-1][2]) + price[i][1];
			min[i][2] = Math.min(min[i-1][0], min[i-1][1]) + price[i][2];
		}
		ans[1] = Math.min(min[cnt][0], min[cnt][2]);
		
		min[2][0] = price[1][2] + price[2][0];	
		min[2][1] = price[1][2] + price[2][1];
		min[2][2] = 10000000;	
		for(int i=3; i<=cnt; i++) {
			min[i][0] = Math.min(min[i-1][1], min[i-1][2]) + price[i][0];
			min[i][1] = Math.min(min[i-1][0], min[i-1][2]) + price[i][1];
			min[i][2] = Math.min(min[i-1][0], min[i-1][1]) + price[i][2];
		}
		ans[2] = Math.min(min[cnt][0], min[cnt][1]);
		
		
		
		System.out.print(Math.min(ans[0], Math.min(ans[1], ans[2])));
		

	}

}
