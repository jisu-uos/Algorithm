package algorithm_그래프_2;

import java.util.*;
import java.io.*;

public class 서울2호선 {
	static int vertex;
	static ArrayList<Integer>[] graph;
	static int[] distance;
	static boolean[] circle;
	static boolean[] visited;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		vertex = Integer.parseInt(br.readLine());
		graph = new ArrayList[vertex];
		distance = new int[vertex];
		circle = new boolean[vertex];
		visited = new boolean[vertex];
		for(int i=0; i<vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<vertex; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			graph[s].add(e);
			graph[e].add(s);
		}


		find_distance();
	}
	
	public static void find_distance() {
		for(int i=0; i<vertex; i++) {
			find_circle(i,i,0);
		}
		
		for(int i=0; i<vertex; i++) {
			if(graph[i].size()>=3)
				go_to_circle(i,0);
		}
		
		for(int i=0; i<vertex; i++) {
			System.out.print(distance[i]+" ");
		}
		
	}
	
	public static void find_circle(int start, int now, int cnt) {
		visited[now] = true;
		for(int i=0; i<graph[now].size(); i++) {
			if(graph[now].get(i) == start && cnt>=2 ) {
				circle[start] = true;
			}
			if(!visited[graph[now].get(i)]) {
				find_circle(start, graph[now].get(i), cnt+1);
			}
		}
		visited[now] = false;
		return;
	}
	
	public static void go_to_circle(int now, int cnt) {
		visited[now] = true;
		distance[now] = cnt;
		for(int i=0; i<graph[now].size(); i++) {
			if(!visited[graph[now].get(i)] && !circle[graph[now].get(i)]) {
				go_to_circle(graph[now].get(i), cnt+1);
			}
		}
		visited[now] = false;
		return;
	}
}
