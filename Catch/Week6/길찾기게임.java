package Week6;

import java.util.*;

public class 길찾기게임 {
	static int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
	
	
	public static void main(String args[]) {
		int[][] answer;
		
		answer = new int[2][nodeinfo.length];
				
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i=0; i<nodeinfo.length; i++) {
			pq.add(new Node(i,nodeinfo[i][0],nodeinfo[i][1]));
		}
		
		Tree tree = new Tree();
		tree.root = pq.poll();
		
		while(!pq.isEmpty()) {
			tree.addNode(pq.poll(), tree.root);
		}

		tree.preOrder(tree.root);
		tree.postOrder(tree.root);
		
		for(int i=0; i<nodeinfo.length; i++) {
			answer[0][i] = (int) tree.pre.get(i);
			answer[1][i] = (int) tree.post.get(i);
		}
		
		for(int i=0; i<nodeinfo.length; i++) {
			System.out.println(answer[0][i]);
		}
	}
}

class Node implements Comparable<Node>{
	int order;
	int x;
	int y;
	Node left;
	Node right;
	public Node(int o, int x, int y) {
		this.order = o;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Node n) {
		if(n.y==this.y) {
			return this.x - n.x;
		}
		return n.y - this.y;
	}	
}

class Tree {
	Node root;
	
	ArrayList pre = new ArrayList<>();
	ArrayList post = new ArrayList<>();
	
	public void addNode(Node add, Node root) {
		if(add.x < root.x) {
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
	
	public void preOrder(Node root) {
		if(root==null)
			return;
		pre.add(root.order+1);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		post.add(root.order+1);
	}
}