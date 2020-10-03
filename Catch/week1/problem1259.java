package week1;

import java.util.*;
import java.io.*;

public class problem1259 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String num = br.readLine();
			
			if(num.equals("0"))
				break;
			
			while(true) {
				if(num.length() > 1) {
					if(num.charAt(0) != num.charAt(num.length()-1)) {
						System.out.println("no");
						break;					
					} else if(num.length() > 2){
						num = num.substring(1,num.length()-1);
						continue;
					} else {
						System.out.println("yes");
						break;
					}
				} else {
					System.out.println("yes");
					break;
				}
			}
		}
		
	}
}
