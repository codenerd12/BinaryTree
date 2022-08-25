package com.problems;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.problems.Tree6TopViewOfTree.Pair;

public class Tree6TopViewOfTree {
	
	public static class Pair {
		int level;
		TreeNode node;
		
		Pair(TreeNode node, int level) {
			this.level = level;
			this.node = node;
		}
	}
	
	
	private static void topViewOfTree(TreeNode root) {
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		
		while(!queue.isEmpty()) {
			
			Pair pair = queue.poll();
			int level = pair.level;
			TreeNode node = pair.node;
			
			if(!map.containsKey(level)) {
				map.put(level, node.data);
			}
			
			if(node.left!=null) {
				Pair temp = new Pair(node.left, level-1);
				queue.add(temp);
			}
			
			if(node.right!=null) {
				Pair temp = new Pair(node.right, level+1);
				queue.add(temp);
			}
			
		}
		
		
		for(Integer key:map.keySet())
			System.out.print(map.get(key)+" ");
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
		topViewOfTree(root);

	}

}
