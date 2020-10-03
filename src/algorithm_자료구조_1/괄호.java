package algorithm_자료구조_1;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {

   public static void main(String[] args) {
    Stack stack = new Stack<>();
	  Scanner sc = new Scanner(System.in);
      int success = 1;
      int cnt = sc.nextInt();
      sc.nextLine();
      for(int i=0; i<cnt; i++) {
    	  String input = sc.nextLine();

        for(int j=0; j<input.length();j++){
          if(input.charAt(j)=='('){
            stack.add(input.charAt(j));  
          } else if(input.charAt(j)==')') {
            if(!stack.empty()){
              stack.pop();      
            }else{
              success = 0;
            }      
          } else{
            success = 0;
          } 
        }
        if(stack.empty() && success==1){
          System.out.println("YES");     
        } else{
          System.out.println("NO");   
        }
        stack.clear();
        success=1;
      }
   }
}
