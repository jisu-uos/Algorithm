package algorithm_브루트포스_4;

import java.io.*;
import java.util.*;

public class 퇴사 {
	static int N;
	static int days[];
	static int pay[];
	static boolean working[];
	static int max;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		days = new int[N];
		pay = new int[N];
		working = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		consulting(0,0);
		System.out.println(max);
	}
	
	public static void consulting(int from, int money) {
		if(from == N) {
			max = max > money ? max : money;
		} else {
			for(int i=from; i<N; i++) {
				if(working[i] == false && (i+days[i]) < N+1) {
					for(int j=i; j<i+days[i]; j++)
						working[j] = true;
					consulting(i+days[i], money+pay[i]);
					for(int j=i; j<i+days[i]; j++)
						working[j] = false;
				}
			}
			from = N;
			consulting(from, money);
		}
	}
}
