package Week9;

import java.io.*;
import java.util.*;

public class problem4485 {
	static int[][] board;
	static int[][] min;
	static int N;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			
			board = new int[N][N];
			min = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					min[i][j] = -1;
				}
			}			
			System.out.println("Problem "+(t++)+": "+BFS());
		}		
	}
	
	public static int BFS() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] start = {0,0};
		min[0][0] = board[0][0];
		q.add(start);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x=now[0];
			int y=now[1];
			if(x==N-1 && y==N-1) continue;
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(min[nx][ny] >= 0 && min[nx][ny] <= min[x][y]+board[nx][ny]) continue;
				min[nx][ny] = min[x][y]+board[nx][ny];
				int[] next = {nx,ny};
				q.add(next);
			}
		}		
		return min[N-1][N-1];
	}
}