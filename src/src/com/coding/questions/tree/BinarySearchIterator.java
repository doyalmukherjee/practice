package com.coding.questions.tree;

import java.util.Stack;

public class BinarySearchIterator {
	Stack<TreeNode> stack;

	public BinarySearchIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode node = stack.pop();
		int result = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left= new TreeNode(3);
		root.left.left= new TreeNode(1);
		root.left.right= new TreeNode(6);
		root.left.right.left= new TreeNode(4);
		root.left.right.right= new TreeNode(7);
		
		root.right= new TreeNode(10);
		root.right.right=new TreeNode(14);
		root.right.right.left= new TreeNode(13);
		
		BinarySearchIterator bsi = new BinarySearchIterator(root);
		while(bsi.hasNext()) {
			System.out.println(bsi.next());		
		}
	}
}
