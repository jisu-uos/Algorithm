package algorithm_그래프_1;

import java.io.*;

public class 미로탐색 {
	static int row, col;
	static boolean maze[][];
	static int now_min[][];
	static int min = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);
		maze = new boolean[row+2][col+2];
		now_min = new int[row+2][col+2];
		
		for(int i=1; i<=row; i++) {
			String str = br.readLine();
			for(int j=1; j<=col; j++) {
				maze[i][j]= str.charAt(j-1)=='1';
			}
		}
		DFS(1,1,1);
		System.out.print(min);
		
		
	}
	
	public static void DFS(int x, int y, int cnt) {
		if(x == row && y == col) {
			if(min==0)
				min = cnt;
			else
				min = min > cnt ? cnt : min;
			return;
		} else if(maze[x][y] && (now_min[x][y]==0 || now_min[x][y] > cnt)) {
			now_min[x][y] = cnt;
			DFS(x-1,y,cnt+1);
			DFS(x+1,y,cnt+1);
			DFS(x,y-1,cnt+1);
			DFS(x,y+1,cnt+1);
			cnt--;
		}
		return;		
	}
}
