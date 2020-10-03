package week2;

import java.io.*;
import java.util.*;

public class problem9012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			check();
		}
		
		System.out.println(sb);
	}
	
	public static void check() throws IOException {
		boolean possible = true;
		String line = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<line.length(); i++) {
			int word = line.charAt(i);
			if(word == '(') {
				stack.push((int)'(');
			} else if(!stack.isEmpty() && stack.pop() == '(') {
				continue;
			} else {
				possible = false;
				break;
			}
		}
		
		if(possible && stack.isEmpty())
			sb.append("YES\n");
		else
			sb.append("NO\n");
	}
}
