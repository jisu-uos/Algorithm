package Week6;

import java.io.*;
import java.util.*;

public class problem2751 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=0; i<N; i++)
			sb.append(pq.poll()+"\n");
		
		System.out.println(sb);
	}
}
