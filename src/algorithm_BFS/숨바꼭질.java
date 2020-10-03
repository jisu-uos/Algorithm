package algorithm_BFS;

import java.util.*;

public class ¼û¹Ù²ÀÁú {
	static int N;
	static int K;
	static boolean[] visited;
	static int shortest;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[2*K];
				
		if(N>=K)
			System.out.println(N-K);
		else {
			BFS();
			System.out.println(shortest);
		}

	}
	
	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>(); 
		q.add(N);
		
		while(!q.isEmpty() ) {
			int now = q.poll();
			if(now == K) {
				return;
			}
			if( 0 <= now && now < K*2) {
				if(!visited[now]) {
					shortest++;
					visited[now] = true;
					
					q.add(now*2);
					q.add(now+1);
					q.add(now-1);	
					
				}							
			}		
		}
	}
}
