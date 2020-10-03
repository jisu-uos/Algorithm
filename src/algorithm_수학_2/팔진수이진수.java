package algorithm_수학_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔진수이진수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String str = br.readLine();
		int m = str.charAt(0)-'0';
		
		if(m>3)
			System.out.print(m/4 +""+ m%4/2 +""+ m%2);
		else if(m>1)
			System.out.print(m%4/2 +""+ m%2);
		else
			System.out.print(m%2);
		
		for(int i=1; i<str.length(); i++) {
			int n = str.charAt(i)-'0';
			System.out.print(n/4 +""+ n%4/2 +""+ n%2);
		}
	}
}

