package com.problems;

public class Tree32CountNodesInCompleteTree {
	
	private static int heightLeft(TreeNode root) {
		int count=0;
		
		while(root.left!=null) {
			count++;
			root = root.left;
		}
		
		return count;
	}
	
	private static int heightRight(TreeNode root) {
		int count=0;
		
		while(root.right!=null) {
			count++;
			root = root.right;
		}
		
		return count;
	}
	
	private static int nodesInCompleteTree(TreeNode root) {
		
		if(root==null)
			return 0;
		
		int lh = heightLeft(root);
		int rh = heightRight(root);
		
		if(lh==rh)
			return ((2<<(lh))-1);
		
		int left = nodesInCompleteTree(root.left);
		int right = nodesInCompleteTree(root.right);
		
		
		return left+right+1;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.out.println("Total Node: "+nodesInCompleteTree(root));

	}

}
