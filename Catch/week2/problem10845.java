package week2;

import java.io.*;
import java.util.*;

public class problem10845 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Deque<Integer> q = new LinkedList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String now = st.nextToken();
			
			if(now.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			} else if(now.equals("pop")) {
				if(!q.isEmpty()) {
					sb.append(q.poll()+"\n");
				} else {
					sb.append("-1\n");
				}
			} else if(now.equals("size")) {
				sb.append(q.size()+"\n");
			} else if(now.equals("empty")) {
				if(q.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if(now.equals("front")) {
				if(q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.peek()+"\n");
			} else {
				if(q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.peekLast()+"\n");
			} 
		}
		
		System.out.println(sb);
	}
}
