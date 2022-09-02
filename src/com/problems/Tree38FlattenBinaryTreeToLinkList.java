package com.problems;

public class Tree38FlattenBinaryTreeToLinkList {
	
	static TreeNode prev = null;
	
	private static void flattenTree(TreeNode root) {

		if(root==null)
			return;
		
		flattenTree(root.right);
		flattenTree(root.left);
		
		root.right = prev;
		root.left = null;
		prev = root;
		
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		
		flattenTree(root);
		
		System.out.println("Root: "+prev);
	}

	

}
