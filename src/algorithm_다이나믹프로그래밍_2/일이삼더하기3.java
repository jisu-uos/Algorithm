package algorithm_다이나믹프로그래밍_2;

import java.util.Scanner;

public class 일이삼더하기3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int list[] = new int[cnt+1];
		long max[] = new long[1000001];
		
		for(int i=1; i<=cnt; i++) {
			list[i] = sc.nextInt();
		}
		
		max[0]=1;
		max[1]=1;
		max[2]=2;
		
		for(int i=3; i<=1000000; i++) {
			max[i] = (max[i-1] + max[i-2] + max[i-3])%1000000009;
		}
		
		for(int i=1; i<=cnt; i++)
			System.out.println(max[list[i]]);
	}

}
