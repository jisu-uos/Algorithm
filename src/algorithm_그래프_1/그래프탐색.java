package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 그래프탐색 {
	static int n, m, v;
	static int graph[][];
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());;
		graph = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<n+1; i++)
			Arrays.fill(graph[i], 0);
		Arrays.fill(visit, false);
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;			
		}
		
		sb = new StringBuilder();
		DFS(v);
		System.out.println(sb);
		
		Arrays.fill(visit, false);
		
		sb = new StringBuilder();
		BFS(v);
		System.out.println(sb);
	}
	
	public static void DFS(int i) {
		visit[i] = true;
		sb.append(i+" ");
		for(int j=1; j<=n; j++) {
			if(graph[i][j] == 1 && visit[j] == false)
				DFS(j);
		}
		
	}
	
	public static void BFS(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visit[i] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp+" ");
			
			for(int j=1; j<=n; j++) {
				if(graph[temp][j]==1 && visit[j]==false) {
					q.offer(j);
					visit[j] = true;
				}
			}
		}
	}
}
