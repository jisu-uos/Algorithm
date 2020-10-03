package algorithm_ºê·çÆ®Æ÷½º_4;

import java.io.*;

public class ¸ÂÃçºÁ {
	static StringBuffer sb;
	static int N;
	static char[][] sign;
	static int[] print;
	static boolean found = false;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sign = new char[N][N];
		print = new int[N];
		String str = br.readLine();
		int order = 0;
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				sign[i][j] = str.charAt(order++);
			}
		}
		
		find(0);
		
		
	}
	
	public static void find(int index) {
		if(found==false) {
			if(index == N) {
				for(int i=0; i<N; i++) {
					System.out.print(print[i]+" ");
				}
				System.out.println();
				found = true;
			} else {
				for(int i=-10; i<=10; i++) {
					if(check(i, index)) {
						print[index] = i;
						find(index+1);
					}
				}
			}
		}
	}
	
	public static boolean check(int n, int index) {		
		int now_index = index;
		for(int i=index; i>=0; i--) {
			if((sign[i][index] == '-' && n < 0) || (sign[i][index] == '0' && n == 0) || (sign[i][index] == '+' && n > 0) ) {
				if(i == 0) {
					return true;					
				}					
				n += print[--now_index];
			} else {
				return false;
			}				
		}
		return true;
	}
}

