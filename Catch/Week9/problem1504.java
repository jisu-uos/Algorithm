package Week9;

import java.io.*;
import java.util.*;

public class problem1504 {
	static int n,m,g,h;
	static int[][] board;
	static int[][] min;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점 수
		m = Integer.parseInt(st.nextToken()); // 엣지 수

		min = new int[n][2];
		for(int i=0; i<n; i++)
			Arrays.fill(min[i], Integer.MAX_VALUE);
		board = new int[n][n];		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1; // 출발
			int b = Integer.parseInt(st.nextToken())-1; // 도착
			int d = Integer.parseInt(st.nextToken()); // 거리
			board[a][b] = d;
			board[b][a] = d;			
		}

		st = new StringTokenizer(br.readLine());
		g = Integer.parseInt(st.nextToken())-1; // 필수 출발
		h = Integer.parseInt(st.nextToken())-1; // 필수 도착 
				
		BFS();
				
		if(min[n-1][1] == Integer.MAX_VALUE)
			min[n-1][1] = -1;
		System.out.println(min[n-1][1]);
	}
	
public static void BFS() {			
		min[0][0] = 0;
		min[0][1] = 0;		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];				
			}
		});
		pq.add(new int[] {0,0,0}); // 출발점, min 누적, 필수 지남?
		
		while(!pq.isEmpty()) { 
			int[] now = pq.poll();
			for(int i=0; i<n; i++) {
				if(board[now[0]][i]==0 || now[0] == i) continue; // 경로 없거나 자기일때
				if((now[0]==g && i==h) || (now[0]==h && i==g)) {
					if(min[i][1] < now[1]+ board[now[0]][i]) continue;
					min[i][1] = now[1]+ board[now[0]][i];
					pq.add(new int[] {i,min[i][1],1});
				} else if(now[2]==1) {
					if(min[i][1] < now[1]+ board[now[0]][i]) continue;
					min[i][1] = now[1]+ board[now[0]][i];
					pq.add(new int[] {i,min[i][1],1});	
				} else if(min[i][0] >= now[1]+ board[now[0]][i]) {
					min[i][0] = now[1]+ board[now[0]][i];
					pq.add(new int[] {i,min[i][0],0});			
				}
			}
		}		
		
	}
}