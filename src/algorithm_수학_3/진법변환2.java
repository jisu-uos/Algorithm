package algorithm_수학_3;

import java.util.Scanner;
import java.util.Stack;

public class 진법변환2 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int B = sc.nextInt();
		
		transform(num,B);
		
	}

	static void transform(int a, int b) {
		
		Stack<Character> stack = new Stack<Character>();
		
		while(a>0) {
			int now = a%b;
			a /= b;
			if(now < 10)
				stack.push(Character.forDigit(now,10));
			else
				stack.push((char)('A'+now-10));
		}
		
		while(!stack.empty())
			System.out.print(stack.pop());
	}
}
