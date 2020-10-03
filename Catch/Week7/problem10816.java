package Week7;

import java.io.*;
import java.util.*;

public class problem10816 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[Integer.parseInt(st.nextToken())+10000000]++;
		}
		

		int M= Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sb.append(nums[Integer.parseInt(st.nextToken())+10000000]+" ");
		}	
		System.out.println(sb);	
	}
}