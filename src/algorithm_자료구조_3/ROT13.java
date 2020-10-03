package algorithm_자료구조_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z')
				sb.append((char)('a' +(ch - 'a' + 13) % 26));
			else if(ch >= 'A' && ch <= 'Z')
				sb.append((char)('A' +(ch - 'A' + 13) % 26));				
			else
				sb.append(ch);
		}
		System.out.println(sb);
	}
}