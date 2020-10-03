package algorithm_브루트포스_5;

import java.io.*;
import java.util.*;

public class 부분수열의합 {
	static int N;
	static int S;
	static int[] list;
	static int count = 0;;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		list = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		part(0,0);
		if(S == 0 & count > 0)
			count--;
		System.out.println(count);
	}
	
	public static void part(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S)
				count++;
			return;
		} else {
			part(cnt+1, sum+list[cnt]);
			part(cnt+1, sum);
		}
	}
}
