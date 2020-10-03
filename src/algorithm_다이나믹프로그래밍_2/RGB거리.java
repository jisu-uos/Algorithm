package algorithm_다이나믹프로그래밍_2;

import java.util.Scanner;

public class RGB거리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int price[][] = new int[cnt+1][3];
		int min[][] = new int[cnt+1][3];
		
		
		for(int i=1; i<=cnt; i++)
			for(int j=0; j<3; j++)
				price[i][j] = sc.nextInt();
		
		
		for(int i=1; i<=cnt; i++) {
			min[i][0] = Math.min(min[i-1][1], min[i-1][2]) + price[i][0];
			min[i][1] = Math.min(min[i-1][0], min[i-1][2]) + price[i][1];
			min[i][2] = Math.min(min[i-1][0], min[i-1][1]) + price[i][2];
		}
		
		System.out.print(Math.min(min[cnt][0], Math.min(min[cnt][1], min[cnt][2])));
	}

}
