package algorithm_자료구조_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 네수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String str = br.readLine();
		int space = 0;
		long a = 0;
		long b = 0;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == ' ')
				space++;
			else {
				if(space<2) {
					a = a*10 + Character.getNumericValue(ch);
				}else {
					b = b*10 + Character.getNumericValue(ch);
				}
			}			
		}		
		System.out.print(a+b);		
	}
}
