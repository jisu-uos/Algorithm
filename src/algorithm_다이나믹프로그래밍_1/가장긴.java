package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 가장긴 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int list[] = new int[cnt+1];
		int longest[] = new int[cnt+1];
		int before[] = new int[cnt+1];
		int max = 0;
		int now = 0;
		
		for(int i=1; i<=cnt; i++) {
			list[i] = sc.nextInt();
			longest[i] = 1;
		}
		
		
		for(int i=2; i<=cnt; i++) {
			for(int j=1; j<i; j++) {
				if(list[i]>list[j] && longest[i]<=longest[j]) {
					longest[i] = longest[j]+1;
					before[i] = j;
				}
					
			}
		}
		
		for(int i=1; i<=cnt; i++) {
			if(max < longest[i]) {
				max = longest[i];
				now = i;
			}			
		}			
		System.out.println(max);
		
		longest[1] = list[now];
		for(int i=2; i<=max; i++) {
			now = before[now];
			longest[i] = list[now];			
		}		
		
		System.out.print(longest[max]);
		
		for(int i=max-1; i>=1; i--) {
			System.out.print(" "+longest[i]);		
		}

		
	
	}
}
