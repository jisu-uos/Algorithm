package algorithm_�ڷᱸ��_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ���ĺ����� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		int[] nums = new int[26];
		
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			
			int j = ch - 'a';
			nums[j]++;
	   }
		
		for(int i=0; i<25; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.print(nums[25]);		
	}
}