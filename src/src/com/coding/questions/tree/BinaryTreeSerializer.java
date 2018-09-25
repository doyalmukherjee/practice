package com.coding.questions.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeSerializer {
		
	/**
     * Serialize tree using level order traversal.
     */
    public String serializeLevelOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuffer buff = new StringBuffer();
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                buff.append("%,");
            } else {
                buff.append(root.val).append(",");
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        for (int i = buff.length() - 1; i >= 0; i--) {
            if (buff.charAt(i) == '%' || buff.charAt(i) == ',') {
                buff.deleteCharAt(i);
            } else {
                break;
            }
        }
        return buff.toString();
    }
    
    /**
     * Deserialize Tree using level order traversal.
     */
    public TreeNode deserializeLevelOrder(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] input = data.split(",");
        Deque<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.offerFirst(new TreeNode(Integer.parseInt(input[index])));
        TreeNode root = queue.peekFirst();
        index++;
        while (!queue.isEmpty()) {
        	TreeNode current = queue.pollFirst();
            if (index < input.length && !input[index].equals("%")) {
                current.left = new TreeNode(Integer.parseInt(input[index]));
                queue.offerLast(current.left);
            }
            index++;
            if (index < input.length && !input[index].equals("%")) {
                current.right = new TreeNode(Integer.parseInt(input[index]));
                queue.offerLast(current.right);
            }
            index++;
        }
        return root;
    }

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left= new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		
		String serialized = new BinaryTreeSerializer().serializeLevelOrder(root);
		System.out.println(serialized);
		new BinaryTreeSerializer().deserializeLevelOrder(serialized);
	}
}
