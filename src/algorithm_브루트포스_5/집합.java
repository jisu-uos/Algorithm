package algorithm_브루트포스_5;

import java.util.*;
import java.io.*;

public class 집합 {
	static int set;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String now = st.nextToken();
			if(now.equals("add")) {
				set = set | (1 << Integer.parseInt(st.nextToken()));
			}
			else if(now.equals("remove")) {
				set = set & ~(1 << Integer.parseInt(st.nextToken()));
			}
			else if(now.equals("check")) {
				if((set&(1<<Integer.parseInt(st.nextToken())))>0)
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(now.equals("toggle")) {
				set = set ^ (1 << Integer.parseInt(st.nextToken()));
			}
			else if(now.equals("all")) {
				set = (1 <<21) -1;
			}
			else {
				set = 0;	
			}
		}		
	}
}
