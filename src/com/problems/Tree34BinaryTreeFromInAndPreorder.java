package com.problems;

import java.util.HashMap;
import java.util.Map;

public class Tree34BinaryTreeFromInAndPreorder {
	
	private static TreeNode constructTree(int[] inOrder, int[] preOrder, Map<Integer, Integer> inMap, int lw, int up, int[] idx) {
		
		if(idx[0]>=preOrder.length || lw>up)
			return null;
		
		int ele = preOrder[idx[0]++];
		int midInd = inMap.get(ele);
		
		TreeNode root = new TreeNode(ele);
		
		root.left = constructTree(inOrder, preOrder, inMap, lw, midInd-1, idx);
		root.right = constructTree(inOrder, preOrder, inMap, midInd+1, up, idx);
		
		
		return root;
	}
	

	public static void main(String[] args) {
		int[] inOrder = {40, 20, 50, 10, 60, 30};
		int[] preOrder = {10, 20, 40, 50, 30, 60};
		
		Map<Integer, Integer> inMap = new HashMap<>();
		for(int i=0;i<inOrder.length;i++)
			inMap.put(inOrder[i], i);
		
		int lw = 0;
		int up = inOrder.length-1;
		int[] idx = {0};
		TreeNode root = constructTree(inOrder, preOrder, inMap, lw, up, idx);
		
		System.out.println(root);

	}

}
