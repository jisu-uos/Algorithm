package algorithm_수학_1;

import java.util.Scanner;

public class 팩토리얼 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int cnt = 0;
		 
		 
		 for(int i = 1; i<n+1; i++) {
			 if(i%5==0) {
				 cnt++;
				 if(i%25==0) {
					 cnt++;
					 if(i%125==0) {
						 cnt++;
					 }
				 }
			 }
		 }	 
		 System.out.print(cnt);				 
	}
}
		 
