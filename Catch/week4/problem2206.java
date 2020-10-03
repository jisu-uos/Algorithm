package week4;

import java.io.*;
import java.util.*;

public class problem2206 {
	static int row;
	static int col;
	static int[][] board;
	static int[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result = -1;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new int[row][col];
		visited = new int[row][col];
		
		for(int i=0; i<row; i++) {
			String line = br.readLine();
			for(int j=0; j<col; j++) {
				if(line.charAt(j)=='1')
					board[i][j]=1;
				else
					board[i][j]=0;
				visited[i][j] = row*col;
			}
		}
		
		BFS();
		System.out.println(result);		
		
	
	}
	
	public static void BFS() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(0,0,1,0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			Dot now = q.poll();
			if(now.x==row-1 && now.y==col-1) {
				if(result==-1 || result>now.count)
					result = now.count;
			}
			for(int i=0; i<4; i++) {
				int x = now.x+dx[i];
				int y = now.y+dy[i];
				if(0<=x && x<row && 0<=y && y<col && now.jump < visited[x][y]) {
					if(board[x][y] == 0) {
						q.add(new Dot(x,y,now.count+1,now.jump));
						visited[x][y] = now.jump;
					} else if(now.jump==0) {
						q.add(new Dot(x,y,now.count+1,1));
						visited[x][y] = 1;
					}
				}
			}
		}
	}
}

class Dot {
	int x;
	int y;
	int count;
	int jump;
	public Dot(int x, int y, int c, int j) {
		this.x = x;
		this.y = y;
		this.count = c;
		this.jump = j;
	}
}