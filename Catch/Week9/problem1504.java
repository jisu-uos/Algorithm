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
		n = Integer.parseInt(st.nextToken()); // ���� ��
		m = Integer.parseInt(st.nextToken()); // ���� ��

		min = new int[n][2];
		for(int i=0; i<n; i++)
			Arrays.fill(min[i], Integer.MAX_VALUE);
		board = new int[n][n];		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1; // ���
			int b = Integer.parseInt(st.nextToken())-1; // ����
			int d = Integer.parseInt(st.nextToken()); // �Ÿ�
			board[a][b] = d;
			board[b][a] = d;			
		}

		st = new StringTokenizer(br.readLine());
		g = Integer.parseInt(st.nextToken())-1; // �ʼ� ���
		h = Integer.parseInt(st.nextToken())-1; // �ʼ� ���� 
				
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
		pq.add(new int[] {0,0,0}); // �����, min ����, �ʼ� ����?
		
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
		
	}
}