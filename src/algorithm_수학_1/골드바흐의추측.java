package algorithm_¼öÇĞ_1;

import java.util.ArrayList;
import java.util.Scanner;

public class °ñµå¹ÙÈåÀÇÃßÃø {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int x = sc.nextInt();		
		 
		 int dec = 0;
		 ArrayList<Integer> list = new ArrayList<>();
		 list.add(2);			
		 for(int i=3;i<1000000;i++) {
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
		 
		 while(x != 0) {			
			 
			 dec = 0;
			 for(int i=1; i<list.size() && dec==0; i++) {
				 for(int j= 1; j<list.size() && list.get(i)+list.get(j) <=x ;j++) {
					 if(list.get(i)+list.get(j) == x) {
						 System.out.println(x+" = "+list.get(i)+" + "+list.get(j));		
						 dec = 1;
					 }							 
				 }
			 }			 
			 x = sc.nextInt();
		 }		 
	}	
}