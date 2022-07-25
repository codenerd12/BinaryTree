package com.problems;

public class Tree3DiameterOfTree {
	
	static int maxi = Integer.MIN_VALUE;
	
	private static int diameterOfTree(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		
		int lh = diameterOfTree(root.left);
		int rh = diameterOfTree(root.right);
		
		maxi = Math.max(maxi, lh+rh);
				
		return 1+Math.max(lh, rh);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(5);
		root.right.left.left.left = new TreeNode(9);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(8);
		
		diameterOfTree(root);
		
		System.out.println(maxi);
		
		

	}


}
