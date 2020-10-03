package algorithm_±×·¡ÇÁ_3;

import java.io.*;
import java.util.*;

public class DFS_array {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean graph[][] = new boolean[N+1][N+1];
		boolean visited[] = new boolean[N+1];
		int parent[] = new int[N+1];
		int success = 1;
		int before = 0;
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = true;
			graph[y][x] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			graph[0][now] = true;
			//System.out.println();
			//System.out.println("now: "+ now);
			//System.out.println("before: "+ before);
			
			for(int k=0; k<N; k++) {		
				int exit = 0;
				for(int j=1; j<=N; j++) {
					//System.out.println("before, j: "+ before+','+j);
					//System.out.println("graph[before][j]: "+ graph[before][j]+", visited[j]:"+visited[j]);
					
					if(graph[before][j] && !visited[j]) {
						exit = 1;
						break;						
					}
				}
				if(exit==1)
					break;
				if(parent[before] == 0)
					break;
				before = parent[before];
			}
			
			//System.out.println("before: "+ before);
			
			if(graph[before][now]) {
				visited[now] = true;
				parent[now] = before;
			} else {
				success = 0;
				break;
			}
			
			before = now;
		}
	
		System.out.println(success);
		
	}
}
