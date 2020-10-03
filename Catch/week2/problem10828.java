package week2;

import java.io.*;
import java.util.*;

public class problem10828 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String now = st.nextToken();
			
			if(now.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(now.equals("pop")) {
				if(!stack.isEmpty()) {
					sb.append(stack.pop()+"\n");
				} else {
					sb.append("-1\n");
				}
			} else if(now.equals("size")) {
				sb.append(stack.size()+"\n");
			} else if(now.equals("empty")) {
				if(stack.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else {
				if(stack.isEmpty())
					sb.append("-1\n");
				else
					sb.append(stack.peek()+"\n");
			}
			
		}
		
		System.out.println(sb);
	}
}
