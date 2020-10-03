package algorithm_���Ʈ����_2;

import java.util.*;
import java.io.*;

public class ������1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int choice[] = new int[m+1];
		int print[] = new int[n];
		
		comb(m, n, choice, print, 0);
	}
	
	public static void comb(int m, int n,int[] choice, int[] print, int cnt) {
		if(cnt==n) {
			for (int i = 0; i < n; i++) {
				System.out.print(print[i]+1);
				if (i != n - 1) 
					System.out.print(' '); 
				} 
			System.out.println(); 
			return;			
		} else {
			for(int i=0; i<m; i++) {
				if(choice[i] == 0) {
					choice[i] = 1;
					print[cnt] = i;
					comb(m,n,choice,print, cnt+1);
					choice[i] = 0;
				}				
			}
		}
	}
	
}
