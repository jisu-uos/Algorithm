package algorithm_����_1;

import java.util.Scanner;

public class ����0�ǰ��� {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 long m = sc.nextInt();
		 long n = sc.nextInt();
		 long five = zero(m, 5);
		 long two = zero(m, 2);
		 five -= zero(n,5);
		 two -= zero(n,5);
		 five -= zero(m-n,5);
		 two -= zero(m-n,5);
		 
		 if(five>two)
			 System.out.print(two);
		 else
			 System.out.print(five);
	}
	
	static long zero(long n, long d) {		
		long m = n;
		long cnt = 0;		
		while(m > 0) {
			cnt += m/d;
			m /= d;
		}		
		return cnt;
	}
}
		 
