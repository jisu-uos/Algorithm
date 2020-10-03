package algorithm_브루트포스_1;

import java.io.*;
import java.util.*;

public class 날짜계산 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int e = Integer.parseInt(st.nextToken())-1;
		int s = Integer.parseInt(st.nextToken())-1;
		int m = Integer.parseInt(st.nextToken())-1;
		int i = s;
		
		while(true) {
			if(i%15==e && i%19==m)
				break;
			i+=28;
		}
		
		System.out.print(i+1);
		
	}
}
