package com.problems;

import java.util.HashMap;
import java.util.Map;

public class Tree35BinaryTreeFromInAndPostorder {

	private static TreeNode constructTree(int[] inOrder, int[] postOrder, Map<Integer, Integer> inMap, int lw, int up, int[] idx) {
		
		if(idx[0]<0 || lw>up)
			return null;
		
		int ele = postOrder[idx[0]--];
		int midInd = inMap.get(ele);
		
		TreeNode root = new TreeNode(ele);
		
		root.right = constructTree(inOrder, postOrder, inMap, midInd+1, up, idx);
		root.left = constructTree(inOrder, postOrder, inMap, lw, midInd-1, idx);
		
		return root;
	}

	public static void main(String[] args) {
		
		int[] inOrder = {40, 20, 50, 10, 60, 30};
		int[] postOrder = {40, 50, 20, 60, 30, 10};
		
		Map<Integer, Integer> inMap = new HashMap<>();
		for(int i=0;i<inOrder.length;i++)
			inMap.put(inOrder[i], i);
		
		int lw = 0;
		int up = inOrder.length-1;
		int[] idx = {postOrder.length-1};
		TreeNode root = constructTree(inOrder, postOrder, inMap, lw, up, idx);
		
		System.out.println(root);


	}

}
