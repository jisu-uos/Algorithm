package Week9;

import java.io.*;
import java.util.*;

public class problem14888 {
	static int N;
	static int[] nums;
	static int max;
	static int min;
	static boolean first=true;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] params = new int[4];
		for(int i=0; i<4; i++)
			params[i] = Integer.parseInt(st.nextToken());
		
		DFS(nums[0],1,params);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void DFS(int now, int cnt, int[] params){
		if(cnt==N) {
			if(first) {
				min=now;
				max=now;
				first=false;
			} else {
				min = Math.min(min, now);
				max = Math.max(max, now);
			}
			return;
		} 
		for(int i=0; i<4; i++) {
			if(params[i]>0) {
				int[] n_params = params.clone();
				n_params[i]--;
				if(i==0) {
					DFS(now+nums[cnt],cnt+1,n_params);
				} else if(i==1) {
					DFS(now-nums[cnt],cnt+1,n_params);					
				} else if(i==2) {
					DFS(now*nums[cnt],cnt+1,n_params);					
				} else {
					DFS(now/nums[cnt],cnt+1,n_params);					
				}
			}
		}
	}
}
