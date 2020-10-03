package Week9;

import java.io.*;
import java.util.*;

public class problem14891 {
	static int[][] wheels;
	static int[] top;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheels = new int[4][8];
		top = new int[4];
		
		for(int i=0; i<4; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				wheels[i][j] = line.charAt(j)-'0';
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wheel = Integer.parseInt(st.nextToken())-1;
			int direc = Integer.parseInt(st.nextToken());
			rotate(wheel, wheel, direc);
		}
		
		result();
	}
	
	public static void rotate(int before, int wheel, int direc) {		
		if(before==wheel) {
			if(together(wheel-1))
				rotate(wheel,wheel-1,-direc);
			if(together(wheel))
				rotate(wheel,wheel+1,-direc);				
		} else if(before < wheel) {
			if(together(wheel))
				rotate(wheel,wheel+1,-direc);		
		} else {
			if(together(wheel-1))
				rotate(wheel,wheel-1,-direc);			
		}
		top[wheel] = (top[wheel]+8-direc)%8;
	}
	
	public static boolean together(int left) {
		if(left<0 || left>=3) return false;
		if(wheels[left][(top[left]+2)%8] != wheels[left+1][(top[left+1]+6)%8])
			return true;
		else
			return false;
	}
	
	public static void result() {
		int sum = 0;
		if(wheels[0][top[0]]==1) sum +=1;
		if(wheels[1][top[1]]==1) sum +=2;
		if(wheels[2][top[2]]==1) sum +=4;
		if(wheels[3][top[3]]==1) sum +=8;
		System.out.println(sum);
	}
}
