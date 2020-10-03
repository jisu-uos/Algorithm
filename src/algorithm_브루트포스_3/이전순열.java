package algorithm_브루트포스_3;

import java.util.*;
import java.io.*;

public class 이전순열 {
	static StringBuilder sb;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int now = -1;
		int first = 0;
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		for(int i=n-1; i>0; i--) {
			if(list[i-1] > list[i]) {
				now = i-1;
				break;
			}				
		}
		if(now == -1)
			System.out.println(now);
		else {
			sb = new StringBuilder();		
			
			for(int i=0; i<now; i++) {
				sb.append(list[i]);
				sb.append(' ');
			}
			
			for(int i=n-1; i>now; i--) {
				if(list[i] < list[now]) {
					first = i;
					break;
				}
			}
			
			sb.append(list[first]);
			list[first] = list[now];
			
			for(int i=n-1; i>now; i--) {
				sb.append(' ');
				sb.append(list[i]);
			}
			
			System.out.println(sb);
		}		
	}
}
