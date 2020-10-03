package algorithm_브루트포스_3;

import java.io.*;
import java.util.*;

public class 차이를최대로 {
	static int max = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		int count[] = new int[n];
		int print[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
				
		comb(list, count, print, n, 0);
		
		System.out.print(max);
		
	}
	
	public static void comb(int[] list, int[] count, int[] print, int n, int cnt) {
		if(cnt == n) {
			int sum=0;
			for(int i=0; i<n-1; i++) {
				sum += print[i]-print[i+1] > 0 ? print[i]-print[i+1] : print[i+1]-print[i] ;
			}
			max = max > sum ? max : sum;
		} else {
			for(int i=0; i<n; i++) {
				if(count[i]==0) {
					count[i]=1;
					print[cnt] = list[i];
					comb(list, count, print, n, cnt+1);
					count[i]=0;
				}
			}
		}
		
	}
}
