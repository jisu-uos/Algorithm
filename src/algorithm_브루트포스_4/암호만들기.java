package algorithm_브루트포스_4;

import java.util.*;
import java.io.*;

public class 암호만들기 {
	static StringBuilder sb;
	static char list[];
	static boolean isVowel[];
	static boolean visited[];
	static int L;
	static int C;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new char[C];
		isVowel = new boolean[C];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			list[i] = st.nextToken().charAt(0);
			if(list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u')
				isVowel[i] = true;
			else
				isVowel[i] = false;
		}
		
		Arrays.sort(list);
		
		sb = new StringBuilder();
		key(0,0);
		System.out.println(sb);
		
	}	
	
	public static void key(int from, int cnt) {
		if(cnt == L) {
			int vowel = 0;
			int consonant = 0;
			for(int i=0; i<C; i++) {
				if(visited[i]) {
					if(isVowel[i])
						vowel++;
					else
						consonant++;
				}					
			}
			if(vowel > 0 && consonant > 1) {
				for(int i=0; i<C; i++) {
					if(visited[i]) {
						sb.append(list[i]);
					}					
				}
				sb.append("\n");
			}
		} else {
			for(int i=from; i<C; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					key(i+1,cnt+1);		
					visited[i] = false;			
				}
			}
		}
	}	
}
