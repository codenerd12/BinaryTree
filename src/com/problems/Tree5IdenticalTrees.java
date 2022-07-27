package com.problems;

public class Tree5IdenticalTrees {
	
	private static boolean isIdentical(TreeNode root1, TreeNode root2) {
		
		if(root1==null || root2==null)
			return root1==root2;
		
		return ((root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.right.left = new TreeNode(4);
		root1.right.right = new TreeNode(5);
		
		System.out.println(isIdentical(root, root1));

	}

}
