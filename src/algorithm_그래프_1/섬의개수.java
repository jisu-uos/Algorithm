package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 섬의개수 {
	static int row, col;
	static int[][] area;
	static int[][] group;
	static int group_num=1;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row= Integer.parseInt(st.nextToken());
			
			if(row == 0 && col ==0)
				break;
			
			area = new int[row+2][col+2];
			group = new int[row+2][col+2];
			
			for(int i=1; i<=row; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=col; j++) {
					area[i][j] = st.nextToken().charAt(0) -'0';
				}
			}
			
			group_num = 1;
			for(int i=1; i<=row; i++) {
				for(int j=1; j<=col; j++) {
					DFS(i,j);
					if(group[i][j] == group_num)
						group_num++;
				}
			}
			
			group_num--;
			System.out.println(group_num);
			group_num=1;
		}			
									
	}
	
	public static void DFS(int x, int y) {
		if(area[x][y]==1 && group[x][y]==0) {
			group[x][y] = group_num;
			DFS(x-1,y);
			DFS(x+1,y);
			DFS(x,y-1);
			DFS(x,y+1);
			DFS(x-1,y-1);
			DFS(x+1,y+1);
			DFS(x+1,y-1);
			DFS(x-1,y+1);
		}
		return;		
	}
}
