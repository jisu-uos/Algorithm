package algorithm_자료구조_1;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class 큐 {

   public static void main(String[] args) {
	  Deque<Integer> queue = new LinkedList<Integer>();
	  Scanner sc = new Scanner(System.in);
      int cnt = sc.nextInt();
  
      for(int i=0; i<cnt; i++) {
    	  String input = sc.next();
    	  if(input.contains("push")) {
    		int input2 = sc.nextInt();
    		queue.add(input2);
    	  }else if(input.equals("pop")){
    		 System.out.println(queue.isEmpty()?-1:queue.remove());
    	  }else if(input.equals("size")) {
    		  System.out.println(queue.size());
    	  }else if(input.equals("empty")) {
    		 System.out.println(queue.isEmpty()?1:0);
    	  }else if(input.equals("front")) {
    		System.out.println(queue.isEmpty()?-1:queue.peek());
    	  }else if(input.equals("back")) {
    		System.out.println(queue.isEmpty()?-1:queue.peekLast());
    	  }
      }
   }
}
