package com.coding.questions.tree;

public class LCABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null)
	        return null;
	 
	    if(root.val==p.val || root.val==q.val)
	        return root;
	 
	    TreeNode l = lowestCommonAncestor(root.left, p, q);
	    TreeNode r = lowestCommonAncestor(root.right, p, q);
	 
	    if(l!=null&&r!=null){
	        return root;
	    }else if(l==null&&r==null){
	        return null;
	    }else{
	        return l==null?r:l;
	    }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right= new TreeNode(1);
		root.right.right= new TreeNode(8);
		root.right.left= new TreeNode(0);
		
		root.left= new TreeNode(5);
		root.left.left= new TreeNode(6);
		root.left.right= new TreeNode(2);
		root.left.right.right= new TreeNode(4);
		root.left.right.left= new TreeNode(7);
		
		System.out.println(new LCABinaryTree().lowestCommonAncestor(root, new TreeNode(6), new TreeNode(4)).val);
	}
}
