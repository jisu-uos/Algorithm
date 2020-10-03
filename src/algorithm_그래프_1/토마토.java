package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 토마토 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int row, col;
	static int[][] tomato;
	static int day=0;
	static int not_ripe=0;
	static Queue<int[]> q;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		tomato = new int[row+2][col+2];
		
		for(int i=1; i<=row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=col; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken())+1;
				if(tomato[i][j]==1)
					not_ripe++;
			}
		}
		
		for(int i=1; i<=row; i++) {
			System.out.println();
			for(int j=1; j<=col; j++) {
				System.out.print(tomato[i][j]+" ");
			}
		}
		System.out.println();
		System.out.println();
		
		count();
		
		System.out.println(not_ripe);
		if(not_ripe>0)
			System.out.print(-1);
		else
			System.out.print(day);

		System.out.println();
		for(int i=1; i<=row; i++) {
			System.out.println();
			for(int j=1; j<=col; j++) {
				System.out.print(tomato[i][j]+" ");
			}
		}
	}
	
	public static void count() {		
		q = new LinkedList<int[]>();		
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				if(tomato[i][j]==2) {
					int[] next = {i,j};
					q.offer(next);
				}
			}
		}
		spread();
		return;
	}	
	
	public static void spread() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];

			tomato[now_x][now_y] = 2;
			
			//System.out.println("visit: "+now_x+","+now_y);
			
			for(int i=0; i<4; i++) {
				int[] next = {now[0]+dx[i], now[1]+dy[i]};
				if(tomato[next[0]][next[1]] == 1) {
					not_ripe--;					
					q.offer(next);	
					tomato[now_x][now_y] = 2;
				}
			}	
			day++;
		}
		return;
	}
}
