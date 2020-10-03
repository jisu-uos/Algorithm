package algorithm_자료구조_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2 {
	static int cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		cnt = Integer.parseInt(br.readLine());
		String str = br.readLine();
		Stack<Double> stack = new Stack<>();
		int[] nums = new int[cnt];
		
		for(int i=0;i<cnt;i++) {
	    	nums[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0; i<str.length();i++) {
			char op = str.charAt(i);
	    	  if(op >= 'A' && op <= 'Z') {
	    		  stack.push((double)nums[op-'A']);
	    	  } else {
	    		  
	                double op2 = stack.pop();
	                double op1 = stack.pop();
	                switch (op) {
	 
	                case '+':
	                    stack.push(op1 + op2);
	                    break;
	                case '-':
	                    stack.push(op1 - op2);
	                    break;
	                case '*':
	                    stack.push(op1 * op2);
	                    break;
	                case '/':
	                    stack.push(op1 / op2);
	                    break;
	                }
	            }
	      }	      
	      System.out.printf("%.2f",stack.pop());  	      
	   }
}
