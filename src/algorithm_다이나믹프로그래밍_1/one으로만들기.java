package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class one으로만들기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] min = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(i==1)
				min[i] = 0;
			else if(i%6 == 0)
				min[i] = Math.min(Math.min(min[i/3],min[i/2]), min[i-1]) + 1;
			else if(i%3 == 0)
				min[i] = Math.min(min[i/3],min[i-1]) + 1;
			else if(i%2 == 0)
				min[i] = Math.min(min[i/2],min[i-1]) + 1;
			else
				min[i] = min[i-1] + 1;				
		}
		
		System.out.println(min[n]);
		
	}
	
	
}
