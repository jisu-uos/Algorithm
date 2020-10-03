package week5;

import java.io.*;
import java.util.*;
import java.math.*;

public class problem1931 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int ans = 0;
		int time = 0;
		
		PriorityQueue<Meet> pq = new PriorityQueue<Meet>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
				
		while(!pq.isEmpty()) {
			Meet now = pq.poll();
			if(now.s >= time) {
				time = now.e;
				ans++;
			} 
		}	
		
		System.out.println(ans);
	}
}

class Meet implements Comparable<Meet>{
	int s;
	int e;
	public Meet(int s, int e) {
		this.s = s;
		this.e = e;		
	}
	
	@Override
	public int compareTo(Meet m) {
		if(this.e == m.e)
			return this.s-m.s;
		return this.e - m.e;
	}
}