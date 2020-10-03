package algorithm_자료구조_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열분석 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = "";
		while((str = br.readLine()) != null)
		analysis(str);			
	}
	
	static void analysis(String str) {
		int[] nums = new int[4];
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch==' ')
				nums[3]++;
			else if('a' <= ch && ch <= 'z')
				nums[0]++;
			else if('A' <= ch && ch <= 'Z')
				nums[1]++;
			else if('0' <= ch && ch <= '9')
				nums[2]++;
		}
		
		for(int i=0; i<3; i++)
			System.out.print(nums[i]+" ");
		System.out.println(nums[3]);
	}
		
}