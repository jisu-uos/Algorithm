package algorithm_���Ʈ����_1;

import java.io.*;
import java.util.*;

public class ��¥��� {
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
