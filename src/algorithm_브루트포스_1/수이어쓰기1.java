package algorithm_브루트포스_1;

import java.io.*;

public class 수이어쓰기1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(sum(n));
		
	}

	public static long sum(int n) {
		int now = n;
		long sum = 0;
		int ten = 0;
		int big = 1;
		int what = 0;
		int ten_temp = 0;
		
		while(now >= 10) {
			now /= 10;
			ten++;
		}
		ten_temp = ten;
		
		while(ten > 0) {
			what = ten;
			big = 1;
			while(what > 1) {
				big *= 10;
				what--;
			}
			
			sum += big*9*ten;
			ten--;
		}			
		
		what = ten_temp;
		while(what > 0) {
			big *= 10;
			what--;
		}
		
		sum += (ten_temp+1)*(n-big+1);
				
		return sum;
	}
}
