package Week7;

import java.io.*;
import java.util.*;

public class problem2503 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		int[][] set = new int[T][3];
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
				set[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int ans=0;
		
		for(int i=123; i<=987; i++) {
			if(i/100 == i%100/10 || i/100==i%10 || i%100/10 == i%10 || i%100/10==0 || i%10==0) continue;
			boolean possible = true;
			for(int j=0; j<T; j++) {
				int num=set[j][0];
				int strike=0, ball=0;
				if(i/100 == num/100)
					strike++;
				else if(num/100 == i%100/10 || num/100 == i%10)
					ball++;
				if(i%100/10 == num%100/10)
					strike++;
				else if(num%100/10 == i/100 || num%100/10 == i%10)
					ball++;
				if(i%10 == num%10)
					strike++;
				else if(num%10 == i%100/10 || num%10 == i/100)
					ball++;
				if(strike!= set[j][1] || ball!= set[j][2]) {
					possible = false;
					break;
				}				
			}
			if(possible)
				ans++;
		}
		
		System.out.println(ans);
		
	}
}
