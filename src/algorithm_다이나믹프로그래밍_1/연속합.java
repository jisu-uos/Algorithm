package algorithm_다이나믹프로그래밍_1;

import java.util.Scanner;

public class 연속합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int list[] = new int[cnt+1];
		int max[] = new int[cnt+1];
		int right[] = new int[cnt+1];
		
		for(int i=1; i<=cnt; i++) {
			list[i] = sc.nextInt();
		}
		
		right[1] = 1;
		max[1] = list[1];
		
		for(int i=2; i<=cnt; i++) {
			int now=0;
			int now_max=list[i];
			int j=i;
			while(j>right[i-1]) {
				now += list[j];			
				j--;
				if(now_max<now)
					now_max = now;				
			}
			
			if(now_max > max[i-1] && now_max > now+max[i-1]) {
				right[i]=i;
				max[i]=now_max;
			}else if(now>0) {
				right[i]=i;
				max[i]=max[i-1]+now;
			}else {
				right[i] = right[i-1];
				max[i] = max[i-1];
			}			
		}
		
		System.out.print(max[cnt]);
		
	}

}

