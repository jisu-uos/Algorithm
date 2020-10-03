package week4;

import java.io.*;
import java.util.*;

public class problem11724 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	static int vertex;
	static int edge;	
	static int result = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
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
		
		start();
		System.out.println(result);
	}
	
	public static void start() {
		for(int i=0; i<vertex; i++) {
			if(!visited[i]) {
				DFS(i);
				result++;
			}
		}
	}
	
	public static void DFS(int from) {
		visited[from] = true;
		
		for(int i=0; i<graph[from].size(); i++) {
			int now = graph[from].get(i);
			if(!visited[now]) {
				DFS(now);	
			}
		}
	}
}
