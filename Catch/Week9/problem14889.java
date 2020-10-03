package Week9;

import java.io.*;
import java.util.*;

public class problem14889 {
	static int N;
	static int power[][];
	static boolean isStart[];
	static int min = -1;
	static int cn;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		isStart = new boolean[N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {	
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		split(0,0);
		System.out.print(min);
		
	}
	
	public static void split(int from, int cnt) {
		if(cnt < N/2 && from >= N) return;
		if(cnt == N/2) {
			int start_sum=0;
			int link_sum=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(isStart[i] && isStart[j])
						start_sum += power[i][j];
					else if(!isStart[i] && !isStart[j])
						link_sum += power[i][j];
				}				
			}
			int diff = start_sum > link_sum ? start_sum-link_sum : link_sum-start_sum;
			if(min == -1)
				min = diff;
			min = min > diff ? diff : min;			
		}else {
			isStart[from] = true;
			split(from+1, cnt+1);
			isStart[from] = false;
			split(from+1, cnt);
		}
	}
	
}
