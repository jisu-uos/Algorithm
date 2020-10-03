package algorithm_브루트포스_1;

import java.io.*;
import java.util.*;

public class 카잉달력 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test = Integer.parseInt(st.nextToken());
		int calender[][] = new int[test][4];
		
		for(int i=0; i<test; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++)
				calender[i][j] = Integer.parseInt(st.nextToken());
			
			System.out.println(year(calender[i][0],calender[i][1],calender[i][2],calender[i][3]));
		}		
		
		
		
	}
	
	public static int year(int m, int n, int x, int y) {
		
		int ans = x-1;
		while(ans%m != x-1 || ans%n != y-1) {
			ans +=m;
			if(ans > m*n+m+n)
				return -1;
		}
		
		return ans+1;
	}
	
}
