package com.coding.questions.tree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LCABinarySearch {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode m = root;
		if (m.val > p.val && m.val < q.val) {
			return m;
		} else if (m.val > p.val && m.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (m.val < p.val && m.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.right= new TreeNode(8);
		root.right.right= new TreeNode(9);
		root.right.left= new TreeNode(7);
		
		root.left= new TreeNode(2);
		root.left.left= new TreeNode(0);
		root.left.right= new TreeNode(4);
		root.left.right.right= new TreeNode(5);
		root.left.right.left= new TreeNode(3);
		
		System.out.println(new LCABinarySearch().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
		
	}
}
