package algorithm_브루트포스_3;

import java.util.*;
import java.io.*;

public class 로또 {
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0)
				break;
			int list[] = new int[n];
			int visit[] = new int[n];
			int print[] = new int[6];
			
			for(int i=0; i<n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			sb = new StringBuilder();
			lotto(list, visit, print, n, 0, 0);
			System.out.println(sb);
			
			
		}



	}
	
	public static void lotto(int[] list, int[] visit, int[] print, int n, int from, int cnt) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				sb.append(print[i]+" ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i=from; i<n; i++) {
				if(visit[i] == 0) {
					visit[i] = 1;
					print[cnt] = list[i];
					lotto(list, visit, print, n, i, cnt+1);
					visit[i] = 0;
				}
			}
		}
	}
	
}
