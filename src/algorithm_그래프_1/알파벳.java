package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 알파벳 {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static boolean path = false;
	
	public static void main(String args[]) throws IOException {
		int[][] arr = new int[11][11];
		arr[10][10] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		visited = new boolean[N];
		
		
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}
		
		DFS(0,1);
		if(path)
			System.out.println(1);
		else
			System.out.println(0);
			
	}
	
	public static void DFS(int index, int cnt) {
		if(cnt==5) {
			System.out.println("visit: "+ index +" count: " +cnt);
			path = true;
			return;
		} else {
			visited[index] = true;
			for(int i=0; i<graph[index].size(); i++ ) {
				if(!visited[graph[index].get(i)]) {
					System.out.println("visit: "+ index +" count: " +cnt);
					visited[graph[index].get(i)] = true;
					DFS(graph[index].get(i), cnt+1);
					visited[graph[index].get(i)] = false;
				}
			}
			visited[index] = false;
		}		
	}
}
