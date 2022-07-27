package com.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Tree8LeftAndRightViewOfTree {
	
	
	public static void leftView(TreeNode root) {
		
		Queue<TreeNode> dq = new LinkedList<>();
		dq.add(root);
		
		while(!dq.isEmpty()) {
			
			int size = dq.size();
			
			for(int i=0;i<size;i++) {
				
				TreeNode node = dq.poll();
				
				if(node!=null && i==0)
					System.out.print(node.data+" ");
				
				if(node!=null && node.left!=null)
					dq.add(node.left);
				
				if(node!=null && node.right!=null)
					dq.add(node.right);
					
			}
			
		}
		
		
	}
	
	public static void rightView(TreeNode root) {
		
		Queue<TreeNode> dq = new LinkedList<>();
		dq.add(root);
		
		while(!dq.isEmpty()) {
			
			int size = dq.size();
			
			for(int i=0;i<size;i++) {
				
				TreeNode node = dq.poll();
				
				if(node!=null && i==0)
					System.out.print(node.data+" ");
				
				if(node!=null && node.right!=null)
					dq.add(node.right);
				
				if(node!=null && node.left!=null)
					dq.add(node.left);
					
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		
		leftView(root);
		System.out.println();
		rightView(root);
		
	}

}
