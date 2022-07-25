package com.problems;

public class Tree2BalancedBinaryTree {
	
	private static int isBalancedBinaryTree(TreeNode root) {

		if(root==null)
			return 0;
		
		int lh = isBalancedBinaryTree(root.left);
		if(lh==-1)
			return -1;
		int rh = isBalancedBinaryTree(root.right);
		if(rh==-1)
			return -1;
		
		if(Math.abs(lh-rh) > 1)
			return -1;
		
		return 1+Math.max(lh, rh);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		
		System.out.println(isBalancedBinaryTree(root)!=-1);

	}

}
