package algorithm_브루트포스_3;

import java.io.*;

public class 모든순열 {
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[n];
		int[] print = new int[n];
		
		sb = new StringBuilder();
		comb(n, count,print, 0);	
		System.out.println(sb);
	}
	
	public static void comb(int n, int[] count, int[] print, int cnt) {
		if(cnt == n) {
			for(int i=0; i<n; i++) {
				sb.append(print[i]+1);
				sb.append(" ");
			}
			sb.append("\n");
		} else {
			for(int i=0; i<n; i++) {
				if(count[i] == 0) {
					count[i] = 1;
					print[cnt] = i;
					comb(n, count, print, cnt+1);
					count[i] = 0;
				}
			}
		}
		
	}

}
