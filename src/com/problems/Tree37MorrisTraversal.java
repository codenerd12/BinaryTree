package com.problems;

import java.util.ArrayList;
import java.util.List;

public class Tree37MorrisTraversal {
	
	private static void preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode cur = root;
		
		while(cur!=null) {
				
			if(cur.left==null) {
				list.add(cur.data);
				cur = cur.right;
			} else {
				
				TreeNode prev = cur.left;
				
				while(prev.right!=null && prev.right!=cur)
					prev = prev.right;
				
				if(prev.right==null) {
					prev.right = cur;
					list.add(cur.data);
					cur = cur.left;
				} else {
					prev.right = null;
					cur = cur.right;
				}
				
			}
			
		}
		
		System.out.println(list);
		
	}
	
	private static void inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode cur = root;
		
		while(cur!=null) {
				
			if(cur.left==null) {
				list.add(cur.data);
				cur = cur.right;
			} else {
				
				TreeNode prev = cur.left;
				
				while(prev.right!=null && prev.right!=cur)
					prev = prev.right;
				
				if(prev.right==null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					prev.right = null;
					list.add(cur.data);
					cur = cur.right;
				}
				
			}
			
		}
		
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		
				/**
				 *	Morris traversal of tree
				 * 
				 * 					1
				 * 
				 * 			2				3
				 * 
				 * 		4		5
				 * 
				 * 					6
				 */
		
		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		
		inorderTraversal(root);
		preorderTraversal(root);
		
	}

}
