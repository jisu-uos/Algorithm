package Week7;

import java.io.*;
import java.util.*;

public class problem2805 {
	static int N;
	static int M;	
	static int[] trees;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());		
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		 Arrays.sort(trees);
		
		System.out.println(find());
		
	}
	
	public static int find() {
		int left = 0;
		int right = N-1;
		int mid=0;
		while(left <= right){
			mid = (left+right)/2;
			int mid_sum = sum(mid);
			if(mid_sum == M)
				return trees[mid];
			else if(mid_sum > M) {
				left = mid+1;		
			} else {
				right = mid-1;		
			}
		}
		int height = trees[Math.min(mid+1, N-1)];
		while(sum2(height) < M) {
			height--;
		}
		return height;
	}
	
	public static int sum(int mid) {
		int sum = 0;
		for(int i=mid+1; i<N; i++) {
			sum += trees[i]-trees[mid];
			if(sum > M)
				break;
		}
		return sum;
	}
	
	public static int sum2(int height) {
		int sum = 0;
		for(int i=N-1; i>=0; i--) {
			if(trees[i] < height)
				break;
			sum += trees[i]-height;
			if(sum > M)
				break;
		}
		return sum;
	}
}