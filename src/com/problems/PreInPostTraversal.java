package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostTraversal {
	
	static class Pair{
		int num;
		TreeNode node;
		
		public Pair(int num, TreeNode node) {
			this.num = num;
			this.node = node;
		}
	}
	
	//Return list of preorder, inorder and postorder
	public static List<List<Integer>> convert(TreeNode root) {
		
		
		if(root==null)
			return null;
		
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(1, root));
		
		while(!st.isEmpty()) {
			
			Pair it = st.pop();
			
			if(it.num==1) {
				pre.add(it.node.data);
				it.num++;
				st.push(it);
				
				if(it.node.left!=null)
					st.push(new Pair(1, it.node.left));
				
			} else if(it.num ==2) {
				in.add(it.node.data);
				it.num++;
				st.push(it);
				
				if(it.node.right!=null)
					st.push(new Pair(1, it.node.right));
				
				
			} else {
				
				post.add(it.node.data);
				
			}
			
		}
		
		
		ans.add(pre);
		ans.add(in);
		ans.add(post);
		
		return ans;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> ans = convert(root);
		System.out.println(ans);

	}

}
