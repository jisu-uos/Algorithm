package algorithm_브루트포스_2;

import java.util.*;
import java.io.*;

public class 엔과엠4 {
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int print[] = new int[n];

		sb = new StringBuilder();		
		comb(0, m, n, print, 0);
		System.out.println(sb);
	}
	
	public static void comb(int from, int m, int n, int[] print, int cnt) {
		if(cnt==n) {
			for (int i = 0; i < n; i++) {
				sb.append(print[i]+1);
				if (i != n - 1) 
					sb.append(' '); 
				} 
			sb.append("\n");
			return;			
		} else {
			for(int i=from; i<m; i++) {
				print[cnt] = i;
				comb(i,m,n,print, cnt+1);							
			}
		}
	}
	
}
