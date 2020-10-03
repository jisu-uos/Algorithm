/*
 * package week4;


import java.io.*;
import java.util.*;

public class problem3055 {
	static int[][] board;
	static Queue<Dot> water_q = new LinkedList<Dot>();
	static Queue<Dot> region_q = new LinkedList<Dot>();
	static int row;
	static int col;
	static int result;
	static boolean find=false;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new int[row][col];
		
		for(int i=0; i<row; i++) {
			String line = br.readLine();
			for(int j=0; j<col; j++) {
				int now = line.charAt(j);
				if(now=='.') {
					board[i][j] = 0; // ºó Áö¿ª
				} else if(now=='*') {
					board[i][j] = 1; // ¹°
					water_q.add(new Dot(i,j));
				} else if(now=='X') {
					board[i][j] = 2; // µ¹					
				} else if(now=='S') {
					board[i][j] = 3; // Start
					region_q.add(new Dot(i,j));
				} else if(now=='D') {
					board[i][j] = 4; // Destination
				}
			}
		}
		
		time();

		if(find)
			System.out.println(result);
		else
			System.out.println("KAKTUS");
	}
	
	public static void time() {
		while(!region_q.isEmpty() && !find) {
			result++;
			spread();
			find();
		}
	}
	
	public static void spread() {
		Queue<Dot> temp_q = new LinkedList<Dot>();
		
		while(!water_q.isEmpty() && !find) {
			Dot now = water_q.poll();
			for(int i=0; i<4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];
				if(0<=x && x<row && 0<=y && y<col && board[x][y]==0) {
					board[x][y] = 1;
					temp_q.add(new Dot(x,y));
				}
			}
		}
		
		water_q = temp_q;
	}
	
	public static void find() {
		Queue<Dot> temp_q = new LinkedList<Dot>();
		
		while(!region_q.isEmpty() && !find) {
			Dot now = region_q.poll();
			for(int i=0; i<4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];
				if(0<=x && x<row && 0<=y && y<col && board[x][y]==0) {
					board[x][y] = 3;
					temp_q.add(new Dot(x,y));
				}
				if(0<=x && x<row && 0<=y && y<col && board[x][y]==4) {
					find = true;
					break;
				}
			}
		}
		
		region_q = temp_q;
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
