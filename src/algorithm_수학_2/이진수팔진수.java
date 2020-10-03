package algorithm_수학_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수팔진수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String str = br.readLine();
		String ans = "";
		
		if(str.length()%3 == 1)
			str = "00"+str;
		if(str.length()%3 == 2)
			str = "0"+str;
			
		
		for(int i=str.length()/3; i>0; i--) {
			int now = Character.getNumericValue(str.charAt(3*i-1));
			now += 2*Character.getNumericValue(str.charAt(3*i-2));
			now += 4*Character.getNumericValue(str.charAt(3*i-3));		
			ans = now + ans;
		}

		System.out.println(ans);
	}
}

