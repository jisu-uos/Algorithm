package algorithm_그래프_3;

import java.io.*;
import java.util.*;

public class BFS스페셜저지 {
	static int vertex;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] expect;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		vertex = Integer.parseInt(br.readLine());
		graph = new ArrayList[vertex];
		visited = new boolean[vertex];
		expect = new int[vertex];
		
		for(int i=0; i<vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<vertex-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			graph[s].add(e);
			graph[e].add(s);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<vertex; i++) {
			expect[i] = Integer.parseInt(st.nextToken())-1;
		}

		System.out.print(BFS(expect));
	}
	
	public static int BFS(int[] expect) {		
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(expect[0]);
		visited[expect[0]] = true;
		list.add(-1);
						
		for(int i=0; i<vertex; i++) {					
			if(list.get(0) == -1)
				list.remove(0);
			int now = 0;
			while(true) {
				if(list.get(now) == -1) {
					return 0;
				}					
				if(list.get(now) == expect[i]) {
					break;					
				}
				now++;
			}			
			list.remove(now);
			for(int j=0; j<graph[expect[i]].size();j++) {
				int add = graph[expect[i]].get(j);
				if(!visited[add]){
					list.add(add);
					visited[add]=true;
				}
			}			
			list.add(-1);			
		}
		return 1;
	}		
}
