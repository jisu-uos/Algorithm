package algorithm_브루트포스_4;

import java.util.*;
import java.io.*;

public class 부등호 {
	static int K;
	static boolean bigger_right[];
	static boolean visited[];
	static int print[];
	static int order=0;
	static int max_print[];
	static int min_print[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		bigger_right = new boolean[K];
		visited = new boolean[10];
		print = new int[K+1];		
		max_print = new int[K+1];		
		min_print = new int[K+1];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<K; i++) {
			if(st.nextToken().charAt(0) == '<')
				bigger_right[i] = true;
			else
				bigger_right[i] = false;
		}
		
		arrange(0);
		for(int i=0; i<K+1; i++) {
			System.out.print(max_print[i]);
		}
		System.out.println();
		for(int i=0; i<K+1; i++) {
			System.out.print(min_print[i]);
		}
				
		
	}
	
	public static void arrange(int cnt) {
		if(cnt==K+1) {
			if(order==0) {
				for(int i=0; i<K+1; i++) {
					min_print[i]=print[i];
				}
			}				
			order++;
			for(int i=0; i<K+1; i++) {
				max_print[i]=print[i];
			}
			return;
		} else {
			for(int i=0; i<10; i++) {
				if(cnt==0) {
					if(!visited[i]) {					
						visited[i] = true;
						print[cnt] = i;
						arrange(cnt+1);
						visited[i] = false;
					}
				} else {
					if(!visited[i] && ( (bigger_right[cnt-1] && print[cnt-1] < i ) || ( !bigger_right[cnt-1] && print[cnt-1] > i ) )) {
						visited[i] = true;
						print[cnt] = i;
						arrange(cnt+1);
						visited[i] = false;
					}
				}
				
			}
		}
	}
}
