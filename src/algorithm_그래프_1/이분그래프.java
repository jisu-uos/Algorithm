package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 이분그래프 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] graph = new ArrayList[vertex];
			for(int j=0; j<vertex; j++) {
				graph[j] = new ArrayList<>();
			}
			int group[] = new int[vertex];
			boolean success = true;
			
			for(int j=0; j<edge; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				graph[x].add(y);
				graph[y].add(x);				
			}
			
			for(int j=0; j<vertex; j++) {
				int now_group = 1;
				for(int k=0; k<graph[j].size(); k++) {
					if(group[graph[j].get(k)]==1) {
						now_group = 2;
						break;
					}
					if(group[graph[j].get(k)]==2) {
						now_group = 1;
						break;
					}
				}
				
				for(int k=0; k<graph[j].size(); k++) {
					if(group[graph[j].get(k)]==now_group) {
						success = false;
						break;
					}
					if(now_group==1)
						group[graph[j].get(k)] = 0;
					else
						group[graph[j].get(k)] = 1;
				}
				group[j] = now_group;
			}
			
			if(success)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
	}
}
