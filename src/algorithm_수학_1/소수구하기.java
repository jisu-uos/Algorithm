package algorithm_수학_1;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수구하기 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int m = sc.nextInt();
		 int n = sc.nextInt();	
		 int dec = 0;
		 ArrayList<Integer> list = new ArrayList<>();
		 list.add(2);	
		 
		 for(int i=3;i<n+1;i++) {
			 dec = 0;
			 for(int j=0;j<list.size()&&dec==0;j++) {
				 if(i % list.get(j) == 0) {
					 dec = 1;
				 }		
				 if(i<list.get(j)*list.get(j))
					 break;
			 }
			 if(dec==0)
				 list.add(i);
		 }
		 
		 for(int j=0;j<list.size();j++) {
			 if(list.get(j)>=m)
				 System.out.println(list.get(j));
		 }    		 
	}	
}