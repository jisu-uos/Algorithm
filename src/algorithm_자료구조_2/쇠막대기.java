package algorithm_�ڷᱸ��_2;

import java.util.Scanner;
import java.util.Stack;

public class �踷��� {
	public static void main(String[] args) {
		Stack stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int bar = 0;

		String input = sc.nextLine();
		
		for(int j=0; j<input.length();j++){			
			if(input.charAt(j)=='(')
				stack.push('(');
			else {
				stack.pop();					
				if(input.charAt(j-1)=='(') {
					bar+=stack.size();					
				}				
				else {
					bar+=1;
				}
			}			
		}
		
		System.out.println(bar);
	}
}
