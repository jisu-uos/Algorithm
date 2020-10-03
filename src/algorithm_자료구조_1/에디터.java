package algorithm_자료구조_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		
		Stack lStack = new Stack<>();
		Stack rStack = new Stack<>();
		for(int i = 0; i < str.length(); i++)
			lStack.add(str.charAt(i));
		
		while(n-- > 0) {
			String cmd = reader.readLine();

			if(cmd.contains("P"))
				lStack.add(cmd.charAt(2));
			else {
				switch(cmd) {
				case "L": 
					if(!lStack.isEmpty())
						rStack.add(lStack.pop());
					break;
				case "D": 
					if(!rStack.isEmpty())
						lStack.add(rStack.pop());
					break;
				case "B": 
					if(!lStack.isEmpty())
						lStack.pop();
					break;
				}
			}
		}
		while(!lStack.isEmpty()) rStack.add(lStack.pop());
		while(!rStack.isEmpty()) System.out.print(rStack.pop());
	}
}

/* 시간 초과
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList words = new ArrayList();
	  Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    int cnt = sc.nextInt();
    int length = line.length();
    int now = length;


    for(int i=0;i<line.length();i++){
      words.add(line.charAt(i));
    }
    
    for(int i=0; i<cnt; i++) {
    	char input = sc.next().charAt(0);
    	if(input == 'L') {
    		now = (now>0)?now-1:now;
    	}else if(input=='D') {
    		now = (now==length+1)?now:now+1;
    	}else if(input=='B') {
    		if(now>0)
    			words.remove(now-1);
    		now = (now>0)?now-1:now;
    		length--;
    	}else if(input=='P') {
    		input = sc.next().charAt(0);
    		words.add(now,input);
    		now++;
    		length++;
    	}
    }
    for(int i=0;i<words.size();i++) {
    	System.out.print(words.get(i));
    }
  }
} 
 
 */