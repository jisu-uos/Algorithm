package algorithm_브루트포스_2;

import java.util.*;
import java.io.*;

public class 엔과엠9 {
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int list[] = new int[m];
		int count[] = new int[m];
		
		int n = Integer.parseInt(st.nextToken());
		int print[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			count[i] = 1;
		}
		Arrays.sort(list);
				
		for(int i=1; i<m; i++) {
			if(list[i]==list[i-1]) {
				for(int j=i+1; j<m; j++) {
					list[j-1] = list[j];
				}
				m--;
				count[i-1]++;
				i--;
			}
		}
		
		sb = new StringBuilder();		
		comb(m, n, list, count, print, 0);
		System.out.println(sb);
	}
	
	public static void comb(int m, int n, int[] list, int[] count, int[] print, int cnt) {
		if(cnt==n) {
			for (int i = 0; i < n; i++) {
				sb.append(list[print[i]]);
				if (i != n - 1) 
					sb.append(' '); 
				} 
			sb.append("\n");
			return;			
		} else {
			for(int i=0; i<m; i++) {
				if(count[i]>0) {
					count[i]--;
					print[cnt] = i;
					comb(m,n,list,count, print, cnt+1);		
					count[i]++;
				}				
			}
		}
	}
	
}
