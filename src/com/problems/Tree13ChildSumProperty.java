package com.problems;

public class Tree13ChildSumProperty {
	
	 public static void changeTree(TreeNode root) {
	        // Write your code here.
	        if(root==null)
	            return;
	        
	        int childSum=0;
	        
	        if(root.left!=null)
	            childSum += root.left.data;
	        if(root.right!=null)
	            childSum += root.right.data;
	        
	        if(root.data <= childSum)
	            root.data = childSum;
	        else {
	            if(root.left!=null)
	                root.left.data = root.data;
	            else if(root.right!=null)
	                root.right.data = root.data;
	        }    
	        
	        changeTree(root.left);
	        changeTree(root.right);
	        
	        int total = 0;
	        
	        if(root.left!=null)
	            total += root.left.data;
	        
	        if(root.right!=null)
	            total += root.right.data;
	        
	        if(root.left!=null || root.right!=null)
	            root.data = total;
	        
	        
	    }

	public static void main(String[] args) {

		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(40);
		
		changeTree(root);
		
		
		
	}

}
