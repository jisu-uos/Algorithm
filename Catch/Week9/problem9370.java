package Week9;

import java.io.*;
import java.util.*;

public class problem9370 {
	static int n,m,t,s,g,h;
	static int[][] board;
	static int[][] min;
	static boolean[] dest;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // ������ ��
			m = Integer.parseInt(st.nextToken()); // ���� ��
			t = Integer.parseInt(st.nextToken()); // ������ �ĺ� ��
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken())-1; // �����
			g = Integer.parseInt(st.nextToken())-1; // �ʼ� ���
			h = Integer.parseInt(st.nextToken())-1; // �ʼ� ���� 

			board = new int[n][n];
			min = new int[n][2]; // pass, no pass
					
			for(int i=0; i<n; i++) {
				Arrays.fill(min[i],  Integer.MAX_VALUE);			
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1; // ���
				int b = Integer.parseInt(st.nextToken())-1; // ����
				int d = Integer.parseInt(st.nextToken()); // �Ÿ�
				board[a][b] = d;
				board[b][a] = d;
				
			}
			
			dest = new boolean[n];
			for(int i=0; i<t; i++) {
				dest[Integer.parseInt(br.readLine())-1] = true;
			}
			
			BFS();	
			if(tc<T-1) sb.append("\n");
		}
		System.out.println(sb);		
	}
	
	public static void BFS() {	
		
		min[s][0] = 0;
		min[s][1] = 0;		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];				
			}
		});
		pq.add(new int[] {s,0,0}); // �����, min ����, �ʼ� ����?
		
		while(!pq.isEmpty()) { 
			int[] now = pq.poll();
			for(int i=0; i<n; i++) {
				if(board[now[0]][i]==0 || now[0] == i) continue; // ��� ���ų� �ڱ��϶�
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
		
		for(int i=0; i<n; i++) {
			if(dest[i] && min[i][1] <= min[i][0])
				sb.append((i+1)+" ");
		}
	}	
}