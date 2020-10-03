/*
 * package week4;
 

import java.io.*;
import java.util.*;

public class problem7576 {
	static int[][] board;
	static int col;
	static int row;
	static int result;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		board = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS();
		check();
		System.out.println(result);
	}
	
	public static void check() {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(board[i][j]==0) {
					result = -1;
					break;
				}
			}
		}
	}
	
	public static void BFS() {
		Queue<Dot> q = new LinkedList<Dot>();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(board[i][j] == 1)
					q.add(new Dot(i,j));
			}
		}
		q.add(new Dot(-1,-1));
		
		while(q.size() > 1) {
			Dot now = q.poll();
			if(now.x < 0) {
				result++;
				q.add(now);
			}
			for(int i=0; i<4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];
				if(0<=x && x<row && 0<=y && y<col && board[x][y]==0) {
					board[x][y] = 1;
					q.add(new Dot(x,y));
				}
			}
		}
	}
}

class Dot {
	int x;
	int y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
*/
