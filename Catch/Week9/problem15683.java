package Week9;

import java.io.*;
import java.util.*;

public class problem15683 {
	static int row;
	static int col;
	static int min;
	static int cam_n;
	static ArrayList<int[]> cams;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col= Integer.parseInt(st.nextToken());
		min = row*col;		
		int[][] board = new int[row][col];
		cams = new ArrayList<int[]>();
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				board[i][j]= Integer.parseInt(st.nextToken());
				if(board[i][j] >=1 && board[i][j] <6) {
					int[] cam_info = new int[3];
					cam_info[0]=board[i][j];
					cam_info[1]=i;
					cam_info[2]=j;
					cams.add(cam_info);					
				}
			}
		}
		cam_n = cams.size();
		DFS(board, 0);
		System.out.println(min);
	}
	
	public static void DFS(int[][] board, int cnt) {		
		if(cnt==cam_n) {
			min = Math.min(min, check(board));
			return;
		}
		int cam = cams.get(cnt)[0];
		int x = cams.get(cnt)[1];
		int y = cams.get(cnt)[2];

		if(cam==1) {
			for(int i=0; i<4;i++) {
				int[][] board2 = copy(board);
				board2 = find(board2, x, y, i);
				DFS(board2,cnt+1);				
			}
		} else if(cam==2) {
			int[][] board2 = copy(board);
			board2 = find(board2,x,y,0);
			board2 = find(board2,x,y,2);
			DFS(board2,cnt+1);	

			board2 = copy(board);
			board2 = find(board2,x,y,1);
			board2 = find(board2,x,y,3);
			DFS(board2,cnt+1);
		} else if(cam==3) {
			int[][] board2 = copy(board);
			board2 = find(board2,x,y,0);
			board2 = find(board2,x,y,1);
			DFS(board2,cnt+1);	

			board2 = copy(board);
			board2 = find(board2,x,y,1);
			board2 = find(board2,x,y,2);
			DFS(board2,cnt+1);
			
			board2 = copy(board);
			board2 = find(board2,x,y,2);
			board2 = find(board2,x,y,3);
			DFS(board2,cnt+1);
			
			board2 = copy(board);
			board2 = find(board2,x,y,3);
			board2 = find(board2,x,y,0);
			DFS(board2,cnt+1);			
		} else if(cam==4) {
			int[][] board2 = copy(board);
			board2 = find(board2,x,y,0);
			board2 = find(board2,x,y,1);
			board2 = find(board2,x,y,2);
			DFS(board2,cnt+1);	

			board2 = copy(board);
			board2 = find(board2,x,y,1);
			board2 = find(board2,x,y,2);
			board2 = find(board2,x,y,3);
			DFS(board2,cnt+1);
			
			board2 = copy(board);
			board2 = find(board2,x,y,2);
			board2 = find(board2,x,y,3);
			board2 = find(board2,x,y,0);
			DFS(board2,cnt+1);
			
			board2 = copy(board);
			board2 = find(board2,x,y,3);
			board2 = find(board2,x,y,0);
			board2 = find(board2,x,y,1);
			DFS(board2,cnt+1);			
		} else {
			int[][] board2 = copy(board);
			board2 = find(board2,x,y,0);
			board2 = find(board2,x,y,1);
			board2 = find(board2,x,y,2);
			board2 = find(board2,x,y,3);
			DFS(board2,cnt+1);				
		}		
	}
	
	public static int[][] find(int[][] board, int x, int y, int direc) {
		int nx = x+dx[direc];
		int ny = y+dy[direc];
		while(true) {
			if(nx<0 || nx>=row || ny<0 || ny>=col || board[nx][ny]==6) break;
			board[nx][ny]=7;

			nx+=dx[direc];
			ny+=dy[direc];
		}
		return board;
	}
	
	public static int[][] copy(int[][] board){
		int[][] copy = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++){
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}
	
	public static int check(int[][] board) {
		int sum=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(board[i][j]==0) sum++;
			}
		}				
		return sum;
	}
}
