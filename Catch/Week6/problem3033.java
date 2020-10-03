package Week6;

import java.io.*;
import java.util.*;

public class problem3033 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String word = br.readLine();
		int max=0;
		
		ArrayList[] alpha = new ArrayList[26];
		
		for(int i=0; i<26; i++)
			alpha[i] = new ArrayList<>();
		
		for(int i=0; i<L; i++) {
			alpha[(word.charAt(i)-'a')].add(i);
		}
		
		for(int i=0; i<26; i++) {
			if(alpha[i].size() < 2)
				continue;
			
			
		}
		
		
		System.out.println(max);
		
	}
}
