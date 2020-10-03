package week1;

import java.io.*;
import java.util.*;

public class problem1920 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			int left = 0;
			int right = arr.length-1;
			int mid = right / 2;
			
			while(true) {
				if(now == arr[mid]) {
					System.out.println(1);
					break;
				}
				if(left >= right) {
					System.out.println(0);
					break;
				}
				if(now > arr[mid]) {
					left = mid+1;
					mid = (left + right) / 2;
					continue;
				}
				if(now < arr[mid]) {
					right = mid-1;
					mid = (left + right) / 2;
					continue;
				}
				
			}
		}
		
	}
}
