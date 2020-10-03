package algorithm_±×·¡ÇÁ_2;

import java.io.*;
import java.util.*;

public class Åõ´å {
	static int row,col;
	static int[][] dot;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean circle = false;
	
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		dot = new int[row+2][col+2];
		visited = new boolean[row+2][col+2];
		
		for(int i=1; i<=row; i++) {
			String string = br.readLine();
			for(int j=1; j<=col; j++) {
				dot[i][j] = string.charAt(j-1)-'A'+1;
			}
		}
		
		find_circle();
		
		if(circle)
			System.out.print("Yes");
		else
			System.out.print("No");
		
	}
	
	public static void find_circle() {
		for(int i=1; i<=row; i++) {
			if(circle)
				break;
			for(int j=1; j<col; j++) {
				int now_count = 0;
				for(int k=0; k<4; k++) {
					if(dot[i][j] == dot[i+dx[k]][j+dy[k]])
						now_count++;
				}
				if(now_count>=2)
					circle(i,j,i,j,dot[i][j],1);
			}
		}
	}
	
	public static void circle(int start_x, int start_y, int x, int y, int color, int cnt) {
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			if(x+dx[i]==start_x && y+dy[i]==start_y && cnt>=3) {
				circle = true;
				return;
			}
			if(!visited[x+dx[i]][y+dy[i]] && color==dot[x+dx[i]][y+dy[i]]) {
				circle(start_x,start_y,x+dx[i],y+dy[i],color, cnt+1);
			}
			
		}
		visited[x][y] = false;		
		return;
	}
	
}
