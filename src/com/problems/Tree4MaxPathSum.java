package com.problems;

public class Tree4MaxPathSum {
	
	private static int maxPathSum(TreeNode root, int[] sum) {

		if(root==null)
			return 0;
		
		int leftSum = maxPathSum(root.left, sum);
		int rightSum = maxPathSum(root.right, sum);
		
		sum[0] = Math.max(sum[0], rightSum+leftSum+root.data);
		
		return root.data+Math.max(leftSum, rightSum);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int[] sum = {0};
		
		maxPathSum(root, sum);
		
		System.out.println("MaxPath: "+sum[0]);

	}

	

}
