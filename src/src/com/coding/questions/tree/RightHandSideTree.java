package com.coding.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightHandSideTree {
	public List<Integer> rightSideView(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if(root == null) 
	    	return result;
	    
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while(queue.size() > 0){
	        //get size here
	        int size = queue.size();
	 
	        for(int i=0; i<size; i++){
	            TreeNode top = queue.remove();
	 
	            //the first element in the queue (right-most of the tree)
	            if(i==0){
	                result.add(top.val);
	            }
	            //add right first
	            if(top.right != null){
	                queue.add(top.right);
	            }
	            //add left
	            if(top.left != null){
	                queue.add(top.left);
	            }
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		
		System.out.println(new RightHandSideTree().rightSideView(root));
	}
}
