package com.coding.questions.tree;

import java.util.LinkedList;

class BNode {
	TreeNode n;
	double left;
	double right;

	public BNode(TreeNode n, double left, double right) {
		this.n = n;
		this.left = left;
		this.right = right;
	}
}

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		LinkedList<BNode> queue = new LinkedList<BNode>();
		queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
		while (!queue.isEmpty()) {
			BNode b = queue.poll();
			if (b.n.val <= b.left || b.n.val >= b.right) {
				return false;
			}
			if (b.n.left != null) {
				queue.offer(new BNode(b.n.left, b.left, b.n.val));
			}
			if (b.n.right != null) {
				queue.offer(new BNode(b.n.right, b.n.val, b.right));
			}
		}
		return true;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		root.right.right= new TreeNode(6);

		System.out.println(new ValidBST().isValidBST(root));
	}
}
