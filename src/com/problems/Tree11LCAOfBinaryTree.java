package com.problems;

public class Tree11LCAOfBinaryTree {
	
	private static TreeNode lca(TreeNode root, int n1, int n2) {
		
		if(root==null)
			return null;
		
		if(root.data == n1 || root.data == n2)
			return root;
		
		TreeNode left = lca(root.left, n1, n2);
		TreeNode right = lca(root.right, n1, n2);
		
		if(left!=null && right!=null)
			return root;
		
		return left!=null?left:right;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(9);
		
		TreeNode node = lca(root, 4, 7);
		
		System.out.println("LCA: "+node.data);

	}

}
