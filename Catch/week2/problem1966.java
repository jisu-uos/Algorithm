package week2;

import java.io.*;
import java.util.*;

public class problem1966 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());			
			int count = 0;
			int now=9;
			int pos=0;
			int next=0;
			boolean find = false;			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			while(!find) {			
				pos = next;
				for(int j=0; j<N; j++) {			
					if(arr[(pos+j)%N] == now) {
						count++;
						next = (pos+j)%N;
					}
					if((pos+j)%N == M && arr[(pos+j)%N]==now) {
						find = true;
						break;
					}
				}
				now--;
			}
			sb.append(count+"\n");			
		}		
		System.out.println(sb);
	}
}
