package week5;

import java.io.*;
import java.util.*;

public class problem2075 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int ans=0;
		
		StringTokenizer st;			
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		ans = arr[N-1][0];
		pq.add(arr[N-1][0]);
		for(int i=1; i<N; i++) {
			pq.add(arr[N-1][i]);
			if(arr[N-1][i] < ans)
				ans = arr[N-1][i];
		}
		
		for(int i=0; i<N; i++) {
			for(int j=N-2; j>=0; j--) {
				if(arr[j][i] > ans)
					pq.add(arr[j][i]);
				else
					break;
			}
		}
		
		for(int i=1; i<N; i++)
			pq.poll();
		
		System.out.println(pq.poll());
		
	}
}
