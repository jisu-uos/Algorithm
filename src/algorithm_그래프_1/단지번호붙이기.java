package algorithm_그래프_1;

import java.io.*;
import java.util.Arrays;

public class 단지번호붙이기 {
	static int N;
	static int[][] area;
	static int[][] group;
	static int group_num=1;
	static int[] group_cnt;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N+2][N+2];
		group = new int[N+2][N+2];
		group_cnt = new int[N*N];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=N; j++) {
				area[i][j] = str.charAt(j-1)-'0';
			}
		}
				
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				DFS(i,j);
				if(group[i][j] == group_num)
					group_num++;
			}
		}
		group_num--;
		
		Arrays.sort(group_cnt);
		
		System.out.println(group_num);
		for(int i=N*N-group_num; i<N*N; i++) {
			System.out.println(group_cnt[i]);
		}	
	}
	
	public static void DFS(int x, int y) {
		if(area[x][y]==1 && group[x][y]==0) {
			group[x][y] = group_num;
			group_cnt[group_num]++;
			DFS(x-1,y);
			DFS(x+1,y);
			DFS(x,y-1);
			DFS(x,y+1);
		}
		return;		
	}
}
