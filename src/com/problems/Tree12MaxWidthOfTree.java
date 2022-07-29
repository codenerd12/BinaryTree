package com.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Tree12MaxWidthOfTree {
	
	public static class Pair {
		
		TreeNode node;
		int val;
		
		public Pair(TreeNode node, int val) {
			this.node = node;
			this.val = val;
		}
		
	}

	public static int maxWidthOfTree(TreeNode root) {
		
		int max = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			int mmin = queue.peek().val;  // to make current index(curid) starting from 0
			int first = 0;
			int last = 0;
			
			for(int i=0;i<size;i++) {
			
				Pair pair = queue.poll();
				TreeNode node = pair.node;
				int curid = pair.val-mmin;
				
				if(i==0)
					first = curid;
				
				if(i==size-1)
					last = curid;
				
				if(node.left!=null) {
					Pair temp = new Pair(node.left, curid*2+1);
					queue.add(temp);
				}
				
				if(node.right!=null) {
					Pair temp = new Pair(node.right, curid*2+2);
					queue.add(temp);
				}
			}
			
			max = Math.max(max, last-first+1);
			
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(8);
		root.right.right = new TreeNode(4);
		
		System.out.println("MaxWidth: "+maxWidthOfTree(root));

	}

}
