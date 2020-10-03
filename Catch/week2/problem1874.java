package week2;

import java.io.*;
import java.util.*;

public class problem1874 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean possible = true;
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int next = 1;
		
		for(int i=0; i<n; i++) {
			int now = Integer.parseInt(br.readLine());						
			while(now >= next) {
				stack.push(next++);
				sb.append("+\n");
			}				
			if(stack.pop() != now) {
				possible = false;
				break;
			} 			
			sb.append("-\n");
		}	
		
		if(possible) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
		br.close();
			
	}
}
