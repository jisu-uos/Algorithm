package algorithm_�ڷᱸ��_1;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class �� {

   public static void main(String[] args) {
	  Deque<Integer> queue = new LinkedList<Integer>();
	  Scanner sc = new Scanner(System.in);
      int cnt = sc.nextInt();
  
      for(int i=0; i<cnt; i++) {
    	  String input = sc.next();
    	  if(input.contains("push_front")) {
    		int input2 = sc.nextInt();
    		queue.addFirst(input2);
    	  }else if(input.contains("push_back")) {
      		int input2 = sc.nextInt();
      		queue.addLast(input2);
      	  }else if(input.equals("pop_front")){
    		 System.out.println(queue.isEmpty()?-1:queue.remove());
    	  }else if(input.equals("pop_back")){
     		 System.out.println(queue.isEmpty()?-1:queue.removeLast());
     	  }else if(input.equals("size")) {
    		  System.out.println(queue.size());
    	  }else if(input.equals("empty")) {
    		 System.out.println(queue.isEmpty()?1:0);
    	  }else if(input.equals("front")) {
    		System.out.println(queue.isEmpty()?-1:queue.peekFirst());
    	  }else if(input.equals("back")) {
    		System.out.println(queue.isEmpty()?-1:queue.peekLast());
    	  }
      }
   }
}

