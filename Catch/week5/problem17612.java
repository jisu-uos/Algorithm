package week5;

import java.io.*;
import java.util.*;

public class problem17612 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Checker> checker_q = new PriorityQueue<Checker>();
		PriorityQueue<User> user_q = new PriorityQueue<User>();
		
		for(int i=0; i<K; i++) {
			checker_q.add(new Checker(i,0));
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int ID = Integer.parseInt(st.nextToken());
			int things = Integer.parseInt(st.nextToken());		
			
			Checker now = checker_q.poll();
			now.things += things;
			checker_q.add(now);
			
			user_q.add(new User(ID, now.things, now.num));
		}
		
		for(int i=0; i<N; i++) {
			User now = user_q.poll();
			ans += (long)now.ID * (long)(i+1);
			System.out.println("ID: "+now.ID +", end: "+now.end+", num: "+now.checker_num+", ans: "+ans);
		}
		
		System.out.println();
		System.out.println(ans);
	}
}

class User implements Comparable<User> {
	int ID;
	int end;
	int checker_num;
	public User(int i,  int e, int c) {
		this.ID = i;
		this.end = e;
		this.checker_num = c;
	}
	
	@Override
	public int compareTo(User u) {
		if(this.end==u.end)
			return u.checker_num - this.checker_num;
		return this.end - u.end;
	}
}

class Checker implements Comparable<Checker> {
	int num;
	int things;
	public Checker(int n, int t) {
		this.num = n;
		this.things = t;
	}
	
	@Override
	public int compareTo(Checker c) {
		if(this.things == c.things) {
			return this.num - c.num;
		}
		return this.things - c.things;
	}
}