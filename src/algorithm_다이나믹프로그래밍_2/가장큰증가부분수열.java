package algorithm_다이나믹프로그래밍_2;

import java.io.*;
import java.util.*;

public class 가장큰증가부분수열 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int list[] = new int[n+1];
		int max[] = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			int now = 0;
			for(int j=1; j<i; j++) {
				if(list[i]>list[j] && now<=max[j])
					now = max[j];
			}
			max[i] = now + list[i];
		}
		
		for(int i=1; i<n; i++) {
			max[n] = max[n] > max[i] ? max[n] : max[i];
		}
		System.out.print(max[n]);
		
	}

}
