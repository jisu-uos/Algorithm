package week5;

import java.util.*;
import java.io.*;

public class problem1838 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		PriorityQueue<Number> pq = new PriorityQueue<Number>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(new Number(i,Integer.parseInt(st.nextToken())));
		}
		
		for(int i=0; i<N; i++) {
			int diff = pq.poll().order - i;
			if(diff > ans)
				ans = diff;
		}

		System.out.println(ans);
	}
}

class Number implements Comparable<Number> {
	int order;
	int num;
	public Number(int o, int n) {
		this.order = o;
		this.num = n;
	}
	
	@Override
	public int compareTo(Number n) {
		return this.num - n.num;
	}
}