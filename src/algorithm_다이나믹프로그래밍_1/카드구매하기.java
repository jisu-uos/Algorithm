package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 카드구매하기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] price = new int[n+1];
		int[] max = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			price[i] = sc.nextInt();
		}
		
		
		max[0] = 0;		
		for(int i=1; i<=n; i++) {
			max[i] = price[1]*i;
			for(int w=2; w<=i; w++) {
				max[i] = Math.max(max[i], max[i-w]+price[w]);
			}				
		}
		
		System.out.println(max[n]);
		
		
		
	}
}