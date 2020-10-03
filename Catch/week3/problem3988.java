package week3;

import java.util.*;
import java.io.*;

public class problem3988 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int min = -1;
		
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
				
		int m = -1;
		int M = -1;
		int m_left = 0;
		
		int s = 0;
		int e = N-K-1;
		int i = 0;
		
		
		while(e < N && i<N-1) {
			if(i >= e) {
				s++;
				e++;
				if(s > m_left) {
					i = s;
					m = arr[i+1]-arr[i];
					m_left = i;
				}
				System.out.println("i>=e");
				continue;
			}
			
			M = arr[e] - arr[s];
			
			if(m==-1 || m>=arr[i+1]-arr[i]) {
				m = arr[i+1]-arr[i];
				m_left = i;
			}
			if(min==-1 || M+m <min)
				min = M+m;	
			System.out.println("s: "+s+", e: "+e+", i: "+i+", m_left: "+m_left+", m: "+m+", M: "+M+", min: "+min );
			
			i++;
		}
		
		System.out.println(min);
		
		
	}
}
