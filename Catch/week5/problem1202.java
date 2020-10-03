package week5;

import java.io.*;
import java.util.*;

public class problem1202 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Gem[] gems = new Gem[N];
		int[] bags = new int[K];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			gems[i] = new Gem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(gems);
		Arrays.sort(bags);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		long ans = 0;
		int j=0;
		for(int i=0; i<K; i++) {
			while(j<N && gems[j].weight <= bags[i]) {
				pq.add(-gems[j].price);
				j++;
			}
			if(!pq.isEmpty()) {
				ans += Math.abs(pq.poll());
			}
		}				
		System.out.println(ans);
	}
}

class Gem implements Comparable<Gem> {
	int weight;
	int price;
	public Gem(int w,  int p) {
		this.weight = w;
		this.price = p;
	}
	
	@Override
	public int compareTo(Gem g) {
		return this.weight - g.weight;
	}
}