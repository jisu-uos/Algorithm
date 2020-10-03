package algorithm_브루트포스_5;

import java.io.*;
import java.util.StringTokenizer;

public class 종이조각 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int point[][] = new int[N][M];
		int by_row = 0;
		int by_col = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				point[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			int now=0;
			for(int j=0; j<M; j++) {
				now = now*10 + point[i][j];
			}
			by_row += now;
		}
		
		for(int i=0; i<M; i++) {
			int now=0;
			for(int j=0; j<N; j++) {
				now = now*10 + point[j][i];
			}
			by_col += now;
		}
		
		if(by_row > by_col)
			System.out.println(by_row);
		else
			System.out.println(by_col);
	}
	
}
