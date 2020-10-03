//런타임 에러,,,,

package algorithm_자료구조_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		String ans="";
		
		for(int i=0; i<str.length(); i++) {
			char x = str.charAt(i);
			
			if(x=='(')
				stack.push(x);
			else if(x==')') {
				while(stack.peek()!='(')
					ans += stack.pop();
				stack.pop();			
			} else if(x=='*'||x=='/') {
				if(!stack.isEmpty())
					while(stack.peek()=='*' || stack.peek()=='/')
						ans += stack.pop();
				stack.push(x);
			} else if (x=='+'||x=='-') {
				while(!stack.isEmpty() && (stack.peek()!='('))
					ans += stack.pop();
				stack.push(x);
			} else
				ans += x;
		}
		while(!stack.isEmpty())
			ans += stack.pop();
		
		System.out.print(ans);
	}
}

