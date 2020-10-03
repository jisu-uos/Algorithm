package Week9;

import java.io.*;
import java.util.*;

public class problem14503 {
	static int row;
	static int col;
	static int[][] board;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int count = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new int[row][col];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int direc = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(x,y,direc);
		System.out.println(count);
	}
	
	public static void DFS(int x, int y, int direc) {
		count++;
		board[x][y] = 2;
		System.out.println("count: "+count+", x: "+x+", y: "+y);
		for(int i=0; i<4; i++) {
			int dir = (direc+3-i)%4;
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(board[nx][ny] == 0) {	
				board[nx][ny] = 2;
				DFS(nx,ny,dir);
				return;
			}
		}
		int dir = (direc+2)%4;
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		if(board[nx][ny] != 1) {
			count--;
			DFS(nx,ny,direc);
		}	
	}
}
