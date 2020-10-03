package algorithm_브루트포스_1;

import java.util.*;
import java.io.*;

public class 일곱난쟁이 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height[] = new int[9];
		int ans1 = 0;
		int ans2 = 0;
		for(int i=0; i<9; i++)
			height[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(height);
		
		for(int i=1; i<9; i++) {
			for(int j=0; j<i; j++) {
				int sum = 0;
				for(int k=0; k<9; k++) {
					sum += height[k];
				}
				sum -= height[i] + height[j];
				if(sum == 100) {
					ans1 = i;
					ans2 = j;
					break;
				}
					
			}
		}
				
		for(int i=0; i<9; i++) {
			if(i != ans1 && i != ans2)
				System.out.println(height[i]);			
		}		
	}	

}
