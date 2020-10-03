package week5;

import java.io.*;
import java.util.*;

public class problem5648 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i=0; i<n; i++) {
			if(st.hasMoreTokens()) {
				String word = st.nextToken();
				String word2="";
				for(int j=word.length()-1;j>=0;j--)
					word2 += word.charAt(j);
				pq.add(Long.parseLong(word2));
			} else {
				st = new StringTokenizer(br.readLine());
				i--;
			}
		}
		
		for(int i=0; i<n; i++) {
			sb.append(pq.poll()+"\n");
		}
		
		System.out.println(sb);
	}
}
