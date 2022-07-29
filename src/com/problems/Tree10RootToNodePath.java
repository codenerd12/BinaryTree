package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree10RootToNodePath {
	
	private static boolean rootToNodePath(TreeNode root, List<Integer> list, int target) {
		
		if(root==null)
			return false;
		
		list.add(root.data);
		
		if(root.data==target) {
			System.out.println(list);
			return true;
		}
		
		boolean left = rootToNodePath(root.left, list, target);
		boolean right = rootToNodePath(root.right, list, target);
		
		if(left || right)
			return true;
		
		list.remove(list.size()-1);
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		
		List<Integer> list = new ArrayList<>();
		boolean isPresent = rootToNodePath(root, list, 7);
		System.out.println("Is Path Present: "+isPresent);
		

	}

}
