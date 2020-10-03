package Week7;

import java.io.*;
import java.util.*;

public class problem8944 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());	
			Tree tree = new Tree();
			tree.root = new Node(Integer.parseInt(st.nextToken()));
			for(int i=1; i<N; i++) {
				tree.addNode(new Node(Integer.parseInt(st.nextToken())), tree.root);
			}			
			tree.setFam(tree.root);
			long ans = tree.calc(tree.root) % 9999991;
			sb.append(ans+"\n");
		}		
		
		System.out.println(sb);
	}
}

class Node{
	int num;
	int fam;
	Node left;
	Node right;
	public Node(int n) {
		this.num = n;
		this.fam = 1;
	}
}

class Tree {
	Node root;
	StringBuilder sb = new StringBuilder();
	public void addNode(Node add, Node root) {
		if(add.num < root.num) {
			if(root.left == null) {
				root.left = add;
			} else {
				addNode(add,root.left);
			}
		} else {
			if(root.right == null) {
				root.right = add;
			} else {
				addNode(add,root.right);
			}
		}
	}
		
	public void postOrder(Node root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		sb.append(root.num+"\n");
	}
	
	public int setFam(Node root) {
		int left = (root.left == null ) ? 0 : setFam(root.left);
		int right = (root.right == null ) ? 0 : setFam(root.right);
		root.fam = left + right + 1;
		return root.fam;
	}
	
	public long calc(Node root) {
		int left = (root.left == null ) ? 0 : root.left.fam;
		int right = (root.right == null ) ? 0 : root.right.fam;
		return fac(left+right)/fac(left)/fac(right)*((root.left == null ) ? 1 : calc(root.left))*((root.right == null ) ? 1 :calc(root.right));	
	}
	
	public long fac(int n) {
		if(n==1 || n==0) return 1;
		else return n*fac(n-1);
	}
}