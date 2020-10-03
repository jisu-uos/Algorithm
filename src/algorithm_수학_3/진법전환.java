package algorithm_수학_3;

import java.util.Scanner;

public class 진법전환 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int B = sc.nextInt();
		
		transform(str,B);
		
	}

	static void transform(String a, int b) {
		int ans = 0;
		
		for(int i = 0; i < a.length(); i++) {
			char now = a.charAt(i);
			ans *= b;
			if('0' <= now && now <= '9')
				ans += now - '0';
			else
				ans += now - 'A' + 10;				
		}
		
		System.out.print(ans);
		
	}
}
