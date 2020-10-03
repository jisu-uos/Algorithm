package algorithm_브루트포스_2;

import java.util.*;
import java.io.*;

public class 엔과엠2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int choice[] = new int[m+1];
		int print[] = new int[n];
		
		comb(0, m, n, choice, print, 0);
	}
	
	public static void comb(int from, int m, int n,int[] choice, int[] print, int cnt) {
		if(cnt==n) {
			for (int i = 0; i < n; i++) {
				System.out.print(print[i]+1);
				if (i != n - 1) 
					System.out.print(' '); 
				} 
			System.out.println(); 
			return;			
		} else {
			for(int i=from; i<m; i++) {
				if(choice[i] == 0) {
					choice[i] = 1;
					print[cnt] = i;
					comb(i+1,m,n,choice,print, cnt+1);
					choice[i] = 0;
				}				
			}
		}
	}
	
}
