package com.problems;

public class Tree1MaxDepth {
	
	private static int maxDepth(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return 1+Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		
		System.out.println(maxDepth(root));
		

	}

}
