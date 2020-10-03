
/*
package week4;

import java.io.*;
import java.util.*;

public class problem1261 {
	static int[][] board;
	static int row;
	static int col;
	static int result;
	static boolean find;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		board = new int[row][col];
		
		for(int i=0; i<row; i++) {
			String line = br.readLine();
			for(int j=0; j<col; j++) {
				if(line.charAt(j)=='1')
					board[i][j] = 1;
				else
					board[i][j] = 0;
			}
		}
		
		BFS();
		System.out.println(result);			
	}
	
	public static void BFS() {
		Queue<Dot> room_q = new LinkedList<Dot>();	
		Queue<Dot> wall_q = new LinkedList<Dot>();	
		Queue<Dot> temp_q = new LinkedList<Dot>();
		room_q.add(new Dot(0,0));
		
		while(!find) {		
			while(!room_q.isEmpty()) {
				Dot now = room_q.poll();
				if(now.x == row-1 && now.y==col-1) {
					find = true;
					break;
				}
				for(int i=0; i<4; i++) {
					int x = now.x + dx[i];
					int y = now.y + dy[i];
					if(0<=x && x<row && 0<=y && y<col) {
						if(board[x][y]==0){ // 원래 빈 곳
							board[x][y] = 2; // visit 표시
							room_q.add(new Dot(x,y));
						} else if(board[x][y]==1) { // 원래 막힌 곳
							board[x][y] = 2; // visit 표시
							wall_q.add(new Dot(x,y));
						} 
					} 
				}
			}
			while(!wall_q.isEmpty()) {
				Dot now = wall_q.poll();
				if(now.x == row-1 && now.y==col-1) {
					find = true;
					break;
				}
				for(int i=0; i<4; i++) {
					int x = now.x + dx[i];
					int y = now.y + dy[i];
					if(0<=x && x<row && 0<=y && y<col) {
						if(board[x][y]==0){ // 원래 빈 곳
							board[x][y] = 2; // visit 표시
							room_q.add(new Dot(x,y));
						} else if(board[x][y]==1) { // 원래 막힌 곳
							board[x][y] = 2; // visit 표시
							temp_q.add(new Dot(x,y));
						} 
					} 
				}
			}
			wall_q.addAll(temp_q);
			temp_q.clear();
			if(find)
				break;
			result++;
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
