package Week7;
/*
import java.io.*;

public class problem5639 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int root = Integer.parseInt(br.readLine());		
		Tree tree = new Tree();
		tree.root = new Node(root);
		
		while(true){
			String input = br.readLine();
			if(input == null || input.isEmpty())
				break;
			tree.addNode(new Node(Integer.parseInt(input)), tree.root);
		}
		tree.postOrder(tree.root);
		
		System.out.println(tree.sb);
	}
}

class Node{
	int num;
	Node left;
	Node right;
	public Node(int n) {
		this.num = n;
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
}
*/