package com.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Tree31MinTimeToBurnTree {
	
	private static TreeNode getParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target) {
		TreeNode targetNode = null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode cur = queue.poll();
			
			if(cur.data==target)
				targetNode = cur;
			
			if(cur.left!=null) {
				parentMap.put(cur.left, cur);
				queue.add(cur.left);
			}
			
			if(cur.right!=null) {
				parentMap.put(cur.right, cur);
				queue.add(cur.right);
			}
			
		}
		
		return targetNode;
		
	}
	
	private static int minTimeToBurn(TreeNode root, int target) {
		int count = 0;
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();
		TreeNode targetNode = getParentMap(root, parentMap, target);
		//base case if target is not present in the tree
		if(targetNode==null)
			return -1;
		
		Map<TreeNode, Boolean> isVisited = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(targetNode);
		isVisited.put(targetNode, true);
		
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			int flag = 0;
			for(int i=0;i<size;i++) {
				
				TreeNode cur = queue.poll();
				
				if(cur.left!=null && !isVisited.containsKey(cur.left)) {
					flag=1;
					queue.add(cur.left);
					isVisited.put(cur.left, true);
				}
				
				if(cur.right!=null && !isVisited.containsKey(cur.right)) {
					flag=1;
					queue.add(cur.right);
					isVisited.put(cur.right, true);
				}
				
				if(parentMap.get(cur)!=null && !isVisited.containsKey(parentMap.get(cur))) {
					flag=1;
					queue.add(parentMap.get(cur));
					isVisited.put(parentMap.get(cur), true);
				}
			}
			
			if(flag==1)
				count++;
			
			
		}
		
		
		
		
		return count;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		System.out.println("Min Time: "+minTimeToBurn(root, 2));

	}

}
