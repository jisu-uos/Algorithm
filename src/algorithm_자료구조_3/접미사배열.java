package algorithm_�ڷᱸ��_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ���̻�迭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String str = br.readLine();
		String[] set = new String[str.length()];
		
		for(int i=0;i<str.length();i++) {
			set[i] = str.substring(i);
		}

		Arrays.sort(set);

		for(int i=0;i<str.length();i++) {
			System.out.println(set[i]);
		}
	}
}


