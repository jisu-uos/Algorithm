package week3;

import java.io.*;

public class problem2220 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		for(int i=1; i<n; i++) {
			for(int j=i; j>1; j /=2) {
				arr[j]=arr[j/2];
			}
			arr[1] = i+1;
		}
		arr[n] = 1;
		
		for(int i=1; i<=n; i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb);
		
	}
}
