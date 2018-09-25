package com.coding.questions.tree;

class Height {
	int height;
}

public class DiameterTree {
	public int diameter(TreeNode root) {
		Height height = new Height();
		return diameter(root, height);
	}

	private int diameter(TreeNode root, Height height) {
		if (root == null) {
			return 0;
		}

		Height leftHeight = new Height();
		Height rightHeight = new Height();
		int dial = diameter(root.left, leftHeight);
		int diar = diameter(root.right, rightHeight);
		height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
		return Math.max(Math.max(dial, diar), (1 + leftHeight.height + rightHeight.height));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		
		DiameterTree dt = new DiameterTree();
		System.out.println(dt.diameter(root));
	}
}
