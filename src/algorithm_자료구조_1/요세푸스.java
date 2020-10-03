package algorithm_자료구조_1;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class 요세푸스 {

   public static void main(String[] args) {
	  Deque<Integer> queue = new LinkedList<Integer>();
	  Scanner sc = new Scanner(System.in);
      int max = sc.nextInt();
      int term = sc.nextInt();
      
      for(int i=1; i<=max;i++) {
    	  queue.add(i);
      }
      
      System.out.print("<");
      for(int j=0;j<max-1;j++) {
          for(int i=1;i<term;i++) {
        	  queue.add(queue.pop());
          }
          System.out.print(queue.pop()+", ");    	  
      }      
      System.out.print(queue.pop()+">");
   }       
}
