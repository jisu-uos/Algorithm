package week4;

import java.io.*;
import java.util.*;

public class problem1260 {
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	static int vertex;
	static int edge;
	static int start;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		graph = new ArrayList[vertex];
		visited = new boolean[vertex];
		
		for(int i=0; i<vertex; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			graph[s].add(e);
			graph[e].add(s);
		}
		
		for(int i=0; i<vertex; i++) {
			Collections.sort(graph[i]);
		}
		
		DFS(start, 0);
		Arrays.fill(visited,false);
		sb.append("\n");
		BFS(start);
		System.out.println(sb);
	}
	
	public static void DFS(int from, int count) {
		visited[from] = true;
		sb.append((from+1)+" ");
		if(count==vertex)
			return;
		for(int i=0; i<graph[from].size(); i++) {
			int now = graph[from].get(i);
			if(!visited[now]) {
				DFS(now, count+1);	
			}
		}
		
	}
	
	public static void BFS(int from) {
		Queue<Integer> q  = new LinkedList<Integer>();
		
		visited[from] = true;
		q.add(from);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append((now+1)+" ");
			for(int i=0; i<graph[now].size(); i++) {
				int temp = graph[now].get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					q.add(temp);
				}
			}
		}
		
	}
}
