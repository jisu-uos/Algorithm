package algorithm_���̳������α׷���_1;

import java.util.Scanner;

public class ��ģ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long num[][] = new long[n+1][2];
		
		num[1][0] = 0;
		num[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			num[i][0] = num[i-1][0] + num[i-1][1];
			num[i][1] = num[i-1][0];					
		}
		
		System.out.print(num[n][0] + num[n][1]);
		
	}

}
