package com.problems;

public class Tree9SymmetricBinaryTree {
	
	private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		
		if(left==null || right==null)
			return left==right;
		
		if(left.data!=right.data)
			return false;
		
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}
	
	private static boolean isSymmetric(TreeNode root) {
		
		if(root==null)
			return true;
				
		return isSymmetricHelp(root.left, root.right);
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(root));
	
	}

}
