package algorithm_자료구조_1;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class 스택수열 {
	
	public static void main(String[] args) {
	    Stack stack = new Stack<>();
		  Scanner sc = new Scanner(System.in);
	      int success = 1;
	      int cnt = sc.nextInt();
	      int num = 1;
        ArrayList signal = new ArrayList();
	      sc.nextLine();
	      for(int i=0; i<cnt; i++) {
	    	  int input = sc.nextInt();
	    	  while(num<=input) {
	    		  stack.push(num++);
            signal.add("+");
	    	  }
	    	  if((int)stack.pop()!=input)
            success=0;
          signal.add("-");          
	      }
        if(success==1){
          for(int j=0;j<signal.size();j++){
            System.out.println(signal.get(j));
          }
        }else{
          System.out.println("NO");
        }
	   }
}