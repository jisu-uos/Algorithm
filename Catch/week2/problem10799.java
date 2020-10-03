package week2;

import java.io.*;
import java.util.*;

public class problem10799 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String bar = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		int part = 0;
		
		for(int i=0; i<bar.length(); i++) {
			int now = bar.charAt(i);
			
			if(now=='(') {
				if(bar.charAt(i+1)==')') {
					part += stack.size();
					i++;
				} else
					stack.push((int)'(');
			} else {
				stack.pop();
				part++;
			}
		}
		System.out.println(part);
		
	}
}
