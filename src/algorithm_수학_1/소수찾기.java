//런타임에러

package algorithm_수학_1;

import java.util.Scanner;

public class 소수찾기 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int cnt = sc.nextInt();
		 int dec = 0;
		 int[] nums = new int[1000];
		 
		 for(int i=2; i<1000;i++){
			nums[i] = 1;
		 }	
		 
		 for(int i=2; i<1000;i++){
			 for(int j=i+1; j<1000;j++) {
				 if(j%i==0)
					 nums[j]=0;
			 }
		 }		 		 
		 nums[1] = 0;
	     
	     for(int i=0; i<cnt; i++) {
			 int num = sc.nextInt();	
			 dec += nums[num];		 
	     }    	    
	     System.out.print(dec);
	}	
}