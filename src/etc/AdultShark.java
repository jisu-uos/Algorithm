package etc;

import java.io.*;
import java.util.*;

public class AdultShark {
   static int N, M, K;
   static int sharks;
   static int count = 0;
   
   static int[] dx = {0,-1,1,0,0};
   static int[] dy = {0,0,0,-1,1};
   
   static int[][] board;
   static int[][] whose_smell;
   static int[][] time_smell;
   static int[][] row_col; // 상어 좌표;
   static int[] direction_now; // 현재 방향 1,2,3,4 -> 상하좌우
   static int[][][] direction; // 선호 방향
   
   public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken()); // N * N
      M = Integer.parseInt(st.nextToken()); // 상어 수
      K = Integer.parseInt(st.nextToken()); // 냄새 시간
      
      sharks = M;
      board = new int[N][N];
      whose_smell = new int[N][N];
      time_smell = new int[N][N];
      row_col = new int[M+1][2];
      direction_now = new int[M+1];
      direction = new int[M+1][5][5];
      
      for(int i=0; i<N; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0; j<N; j++) {
            int x = Integer.parseInt(st.nextToken());
            if(x > 0) {
               row_col[x][0] = i;
               row_col[x][1] = j;
               board[i][j] = x;
               whose_smell[i][j] = x;;
               time_smell[i][j] = K;
               
            }
            
         }
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=1; i<=M; i++) {
         direction_now[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int i=1; i<=M; i++) {
         for(int j=1; j<=4; j++) {
            st = new StringTokenizer(br.readLine());
            for(int k=1; k<=4; k++) {
               direction[i][j][k] = Integer.parseInt(st.nextToken());
            }
         }
      }
      
      
      while(sharks > 1) {
    	  count++;
    	  find();
    	  
    	  if(count > 1000) {
    		  count = -1;
    		  break;
    	  }
    	  
      }
      
      System.out.println(count);
      
   }
   
   
   public static void time() {
	   for(int i=0; i<N; i++) {
		   for(int j=0; j<N; j++) {
			   if(time_smell[i][j] > 0 )
				   time_smell[i][j]--;
			   if(time_smell[i][j]==0)
				   whose_smell[i][j] = 0;
		   }
	   }
   }
   
   public static void find() {
      for(int i=1; i<=M; i++) {
         if(row_col[i][0]>=0) {
        	 for(int j=1; j<=4; j++) {
        		 if(move(i,direction_now[i],j,false))
        			 break;
        		 if(j==4) {
        			 for(int k=1; k<=4; k++) {
        				 if(move(i,direction_now[i],k,true))
        					 break;
        			 }
        		 }
        	 }        	 
         }         
     }
      time();
      for(int i=1; i<=M; i++) {
    	  if(row_col[i][0]>=0)
    		  after_move(i,row_col[i][0],row_col[i][1]);
      }
   }
   
   public static boolean move(int index, int direc, int order, boolean go_back) {
	   int x = row_col[index][0] + dx[direction[index][direc][order]];
	   int y = row_col[index][1] + dy[direction[index][direc][order]];
	   int before_x = row_col[index][0];
	   int before_y = row_col[index][1];	   
	   
	   if(!go_back) {
		   if(0 > x || x >= N || 0 > y || y >= N || time_smell[x][y] > 0)
			   return false;
	   } else {
		   if(0 > x || x >= N || 0 > y || y >= N || whose_smell[x][y] != index)
			   return false;
	   }		   
	   
	   row_col[index][0] = x;
	   row_col[index][1] = y;	  
	   direction_now[index] = direction[index][direc][order];	   
	   
	   if(board[x][y] > 0) {
		   row_col[index][0] = -1;
		   sharks--;
	   } else {
		   board[x][y] = index;		  
	   }
	   board[before_x][before_y] = 0;
	   
	   return true;
   }
   
   
   public static void after_move(int index, int x, int y) {	   
	   whose_smell[x][y] = index;
	   time_smell[x][y] = K;	   
   }
}