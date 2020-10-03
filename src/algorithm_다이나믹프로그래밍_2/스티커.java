package algorithm_다이나믹프로그래밍_2;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			int col = Integer.parseInt(br.readLine());
			int point[][] = new int[2][col+1];
			int max[][] = new int[col+1][3];
			
			for(int j=0; j<2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=1; k<=col; k++) {
					point[j][k] = Integer.parseInt(st.nextToken());
				}				
			}
			
			for(int j=1; j<=col; j++) {
				max[j][0] = max_3(max[j-1][0],max[j-1][1],max[j-1][2]);
				max[j][1] = Math.max(max[j-1][0], max[j-1][2]) + point[0][j];
				max[j][2] = Math.max(max[j-1][0], max[j-1][1]) + point[1][j];
			}			
			System.out.println(max_3(max[col][0],max[col][1],max[col][2]));
		}
		
		
	}
	
	public static int max_3(int a,int b,int c) {
		int s;
		s = a>b ? a : b;
		s = s>c ? s : c;
		return s;
	}

	
}
