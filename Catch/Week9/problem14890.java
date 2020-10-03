package Week9;

import java.io.*;
import java.util.*;

public class problem14890 {
	static int N;
	static int L;
	static int[][] board;
	static int result;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		check();
	}
	
	public static void check() {
		for(int i=0; i<N; i++) {
			row(i);
			col(i);
		}
		System.out.println(result);
	}
	
	public static void row(int n) {
		int last_up=-1;
		boolean succ = true;
		for(int i=1; i<N; i++) {
			if(board[n][i] == board[n][i-1]) {
				continue;
			} else if(board[n][i] - board[n][i-1] == 1) {
				if(i-L <= last_up) {
					succ = false;
					break;
				}
				for(int j=i-2; j>=i-L; j--) {
					if(board[n][i-1] != board[n][j]) {
						succ = false;
						break;
					}
				}
				if(!succ) break;
				last_up = i-1;
			} else if(board[n][i] - board[n][i-1] == -1) {
				if(i+L>=N+1) {
					succ=false;
					break;
				}
				for(int j=i+1; j<i+L; j++) {
					if(board[n][i] != board[n][j]) {
						succ = false;
						break;
					}					
				}
				if(!succ) break;
				last_up = i+L-1;				
			} else {
				succ = false;
				break;
			}
		}
		if(succ) result++;
	}
	
	public static void col(int n) {
		int last_up=-1;
		boolean succ = true;
		for(int i=1; i<N; i++) {
			if(board[i][n] == board[i-1][n]) {
				continue;
			} else if(board[i][n] - board[i-1][n] == 1) {
				if(i-L <= last_up) {
					succ = false;
					break;
				}
				for(int j=i-2; j>=i-L; j--) {
					if(board[i-1][n] != board[j][n]) {
						succ = false;
						break;
					}
				}
				if(!succ) break;
				last_up = i-1;
			} else if(board[i][n] - board[i-1][n] == -1) {
				if(i+L>=N+1) {
					succ=false;
					break;
				}
				for(int j=i+1; j<i+L; j++) {
					if(board[i][n] != board[j][n]) {
						succ = false;
						break;
					}					
				}
				if(!succ) break;
				last_up = i+L-1;				
			} else {
				succ = false;
				break;
			}
		}
		if(succ) result++;
	}
	
}
