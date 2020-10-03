package algorithm_수학_3;

import java.util.Scanner;
import java.util.Stack;

public class 진수Conversion {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			ans *= A;
			ans += sc.nextInt();
		}
		
		
		while(ans>0) {
			stack.push(ans%B);
			ans /= B;
		}

		System.out.print(stack.pop());
		while(!stack.empty())
			System.out.print(" "+stack.pop());
		
	}
}
