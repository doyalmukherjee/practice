package com.coding.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(final int x) { val = x; }
}

public class LevelOrderTree {
    public ArrayList<ArrayList<Integer>> levelOrder(final TreeNode root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        if(root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);

            nodeValues.add(node.val);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<TreeNode>();
                al.add(nodeValues);
                nodeValues = new ArrayList();
            }

        }
        return al;
    }

    public List<List<Integer>> levelOrderD(final TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nodeValues= new ArrayList<Integer>();
        if(root==null)
            return result;
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        while(!current.isEmpty()){
            TreeNode node =current.remove();
            if(node.left!=null)
                next.add(node.left);
            if(node.right!=null)
                next.add(node.right);
            nodeValues.add(node.val);
            if(current.isEmpty()){
                current=next;
                next = new LinkedList<TreeNode>();
                result.add(nodeValues);
                nodeValues.clear();
            }
        }
        return result;
    }

    public static void main(final String[] args) {
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(9);
        root.right= new TreeNode(20);
        root.right.right= new TreeNode(7);
        root.right.left= new TreeNode(15);

        System.out.println(new LevelOrderTree().levelOrderD(root));
    }
}
