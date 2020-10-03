package algorithm_그래프_1;

import java.io.*;
import java.util.*;

public class 나이트의이동 {
	static int size, from_x, from_y, to_x, to_y;
	static boolean[][] visited;
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TestCase = Integer.parseInt(br.readLine());
		for(int i=0; i<TestCase; i++) {
			size = Integer.parseInt(br.readLine());
			visited = new boolean[size][size];
			st = new StringTokenizer(br.readLine());
			from_x = Integer.parseInt(st.nextToken());
			from_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			to_x = Integer.parseInt(st.nextToken());
			to_y = Integer.parseInt(st.nextToken());
			
			System.out.println(BFS());
		}

	}
	
	public static int BFS() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(from_x,from_y,0));
		visited[from_x][from_y] = true;
		
		while(!q.isEmpty()) {
			Dot now = q.poll();
			if(now.x == to_x && now.y == to_y) {
				return now.depth;
			}
			for(int i=0; i<8; i++) {
				int next_x = now.x+dx[i];
				int next_y = now.y+dy[i];
				if( 0<=next_x && next_x<size && 0<=next_y && next_y<size && !visited[next_x][next_y]) {
					q.add(new Dot(next_x,next_y,now.depth+1));
					visited[next_x][next_y] = true;
				}					
			}
			
		}
		
		return 0;
	}
}

class Dot {
	int x;
	int y;
	int depth;
	public Dot(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
