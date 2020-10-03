package algorithm_브루트포스_2;

import java.util.*;
import java.io.*;

public class 엔과엠6 {
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int list[] = new int[m];
		int choice[] =new int[m];
		
		int n = Integer.parseInt(st.nextToken());
		int print[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			list[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(list);
		
		sb = new StringBuilder();		
		comb(0, m, n, list, choice, print, 0);
		System.out.println(sb);
	}
	
	public static void comb(int from, int m, int n, int[] list, int[] choice, int[] print, int cnt) {
		if(cnt==n) {
			for (int i = 0; i < n; i++) {
				sb.append(list[print[i]]);
				if (i != n - 1) 
					sb.append(' '); 
				} 
			sb.append("\n");
			return;			
		} else {
			for(int i=from; i<m; i++) {
				if(choice[i] == 0) {
					choice[i] = 1;
					print[cnt] = i;
					comb(i+1, m,n,list, choice, print, cnt+1);	
					choice[i] = 0;
				}						
			}
		}
	}
	
}
