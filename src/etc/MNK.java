package etc;

import java.util.Scanner;

public class MNK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		long result = 0;
		long first = abk(n/2,m/2,k);
		long second = abk((n+1)/2,m/2,k);
		
		System.out.println(first);
		System.out.println(second);
		
		result = first * second * 2;
		
		System.out.println(result);			
		
	}
	
	static long comb(int n, int r) {
		long num = 1;
		int x = r;
		if(r==0)
			return 1;
		while(x > 0) {
			num *= n;
			n--;
			x--;
		}

		while(r > 1) {
			num /= r;
			r--;
		}		
		return num;		
	}
	
	/*	
	static long comb(int n, int r) {
		if(n == r || r == 0) return 1; 
		else return comb(n - 1, r - 1) + comb(n - 1, r); 
	}
*/
	
	static long abk(int a, int b, int k) {
		long x = 0;
		long y = 0;
		
		if(b-a<0)
			x = 0;
		else
		    x = comb(b-1,b-a);
		
		if(b-a-k<0)
			y = 0;
		else
			y = comb(b-k-1,b-a-k);		
		
		return x-y;
	}
}
