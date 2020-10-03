package algorithm_그래프_3;

import java.io.*;
import java.util.*;

public class DFS스페셜저지 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		int parent[] = new int[N+1];
		int success = 1;
		int before = 0;
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		st = new StringTokenizer(br.readLine());
		int now = Integer.parseInt(st.nextToken());
		before = now;
		for(int i=1; i<N; i++) {
			now = Integer.parseInt(st.nextToken());
			while(graph[before].size() == 0) {					
				before = parent[before];
			}	
			if(graph[before].size() == 0) {
				success=0;
				break;
			}
			int j=-1;
			for(j=0; j<graph[before].size();j++) {
				if(graph[before].get(j) == now) {
					graph[before].remove(j);
					break;
				}
				if(j>=graph[before].size()-1) {
					success=0;
					break;
				}
			}				
			for(int k=0; k<graph[now].size();k++) {
				if(graph[now].get(k) == before){
					graph[now].remove(k);
					break;
				}
			}	
			parent[now] = before;				
			before = now;
		}
	
		System.out.println(success);
		
	}
}
