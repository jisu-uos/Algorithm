package algorithm_자료구조_2;

import java.util.Scanner;
import java.util.Stack;

public class 단어뒤집기2 {

	public static void main(String[] args) {
		Stack stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();

		for(int j=0; j<input.length();j++){
			if(input.charAt(j)=='<') {
				while(!stack.empty()){
			          System.out.print(stack.pop());
			        }
				while(input.charAt(j)!='>') {					
					System.out.print(input.charAt(j));
					j++;
				}
				System.out.print(input.charAt(j));
				continue;
			}
			if(input.charAt(j)==' '){
	            while(!stack.empty()){
	              System.out.print(stack.pop());
	            }            
	            System.out.print(' ');
	          } else {
	            stack.add(input.charAt(j));            
	          }            
	        }
	        while(!stack.empty()){
	          System.out.print(stack.pop());
	        }            
	        System.out.println();
		}
}