package algorithm_���̳������α׷���_1;

import java.util.Scanner;

public class ī�屸���ϱ�2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] price = new int[n+1];
		int[] min = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			price[i] = sc.nextInt();
		}
		
		min[0] = 0;		
		for(int i=1; i<=n; i++) {
			min[i] = price[1]*i;
			for(int w=2; w<=i; w++) {
				min[i] = Math.min(min[i], min[i-w]+price[w]);
			}				
		}
		
		System.out.println(min[n]);

	}

}
