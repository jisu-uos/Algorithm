package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 연결요소의개수 {
	static int N, M;
	static boolean[][] graph;
	static int[] group;
	static int group_i = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new boolean[N][N];
		group = new int[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			graph[x][y] = true;
			graph[y][x] = true;			
		}
		
		for(int i=0; i<N; i++) {
			if(group[i] == 0) {
				group_i++;
				DFS(i,0);				
			}				
		}
		
		System.out.println(group_i);
		
		
	}
	
	public static void DFS(int start, int cnt) {
		if(cnt == N) {
			return;
		} else {
			group[start] = group_i;
			for(int i=0; i<N; i++) {
				if(group[i]==0 && graph[start][i]) {
					group[i] = group_i;
					DFS(i, cnt+1);					
				}
			}
		}
	}
}
