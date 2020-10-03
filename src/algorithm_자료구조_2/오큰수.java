package algorithm_자료구조_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class 오큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int [] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        int [] ans = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek() <= a[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(a[i]);
        }
        for(int k : ans) {
            sb.append(k+" ");
        }
        System.out.print(sb.toString());
    }
}


/* 시간초과
public class 오큰수 {

   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
      Stack<Integer> stack = new Stack<>();
      Stack<Integer> ans = new Stack<>();
      int cnt = sc.nextInt();
      int[] list = new int[cnt];

      for(int i=0;i<cnt;i++) {
    	  list[i] = sc.nextInt();
      }
      
      for(int i=cnt-1;i>=0;i--) {
    	 while(!stack.isEmpty() && stack.peek()<=list[i])
    		 stack.pop();
    	 if(stack.isEmpty())
    		 ans.push(-1);
    	 else
    		 ans.push(stack.peek());
    	 stack.push(list[i]);
      }

      while(ans.size() > 1)
    	  System.out.print(ans.pop()+" ");
      System.out.print(ans.pop());
   }
}
*/
