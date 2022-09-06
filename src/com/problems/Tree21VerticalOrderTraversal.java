package com.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree21VerticalOrderTraversal {
	
	static class Pair {
		
		int vert;
		int level;
		TreeNode node;
		
		public Pair(int vert, int level, TreeNode node) {
			this.vert = vert;
			this.level = level;
			this.node = node;
		}
	}
	
	public static void verticalTraversal(TreeNode root) {
		
		Map<Integer, Map<Integer,List<Integer>>> map = new TreeMap<>();
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0, root));
		
		
		while(!queue.isEmpty()) {
				
				Pair pair = queue.poll();
				int vert = pair.vert;
				int level = pair.level;
				TreeNode node = pair.node;
				
				if(!map.containsKey(vert)) {
					map.put(vert, new TreeMap<>());
				} 
				
				if(!map.get(vert).containsKey(level)) {
					map.get(vert).put(level, new ArrayList<>());
				}
				
				map.get(vert).get(level).add(node.data);
				
				if(node.left!=null) {
					queue.add(new Pair(vert-1, level+1, node.left));
					
				}
				
				if(node.right!=null) {
					queue.add(new Pair(vert+1, level+1, node.right));
				}
				
			
		}
		
		//System.out.println(map);
		List<List<Integer>> ans = new ArrayList<>();
		
		for(Map<Integer, List<Integer>> level:map.values()) {
			List<Integer> list = new ArrayList<>();
			for(List<Integer> temp:level.values()) {
				
				for(int i=0;i<temp.size();i++)
					list.add(temp.get(i));
					
			}
			//Collections.sort(list);
			ans.add(list);
			
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) {
		
		/**
		 * 				  1
		 * 
		 * 		  2					3
		 * 
		 * 4			10	9				10
		 * 
		 * 
		 * 		  5
		 * 
		 * 				 6
		 * 
		 */
		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		root.left.left.right.right = new TreeNode(6);
		root.left.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(10);

		verticalTraversal(root);
		
	}

}
