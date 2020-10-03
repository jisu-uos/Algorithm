package Week6;

import java.io.*;
import java.util.*;

public class problem6549 {
	static int[] arr;
	static int n;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0)
				break;
			
			arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getMax(0,N-1)+"\n");
		}
		
		System.out.println(sb);
	}
	
	public static long getMax(int left, int right) {
		if(left==right) return arr[left];
		
		int mid = (left+right)/2;
		long ret = Math.max(getMax(left,mid), getMax(mid+1,right));
		
		int start = mid;
		int end = mid+1;
		
		long height = (long)Math.min(arr[start], arr[end]);
		ret = (long)Math.max(ret, height*2);
		
		while(left < start || end < right){
			if(left < start && end < right){
				if(arr[start -1] < arr[end+1])
					height = (long)Math.min(height, arr[++end]);
				else
					height = (long)Math.min(height, arr[--start]);
			}
			else if(left < start){
				height = (long)Math.min(height, arr[--start]);
			}
			else if(end < right){
				height = (long)Math.min(height, arr[++end]);
			}
			ret = Math.max(ret, height*(end-start+1));
		}		
		return ret;
	}
}
