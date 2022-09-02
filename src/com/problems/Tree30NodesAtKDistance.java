package com.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Tree30NodesAtKDistance {
	
	public static Map<TreeNode, TreeNode> getParentMap(TreeNode root) {
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode cur = queue.poll();
			
			if(cur.left!=null) {
				parentMap.put(cur.left, cur);
				queue.add(cur.left);
			}
			
			if(cur.right!=null) {
				parentMap.put(cur.right, cur);
				queue.add(cur.right);
			}
			
		}
		
		return parentMap;
		
	}
	
	
	public static void nodeatKdistance(TreeNode root, TreeNode target, int k) {
		
		Map<TreeNode, TreeNode> parentMap = getParentMap(root);
		//System.out.println("Size: "+parentMap.size());
		Map<TreeNode, Boolean> isVisited = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(target);
		isVisited.put(target, true);
		
		
		while(!queue.isEmpty()) {

			if(k==0)
				break;
			
			k--;
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				
				TreeNode cur = queue.poll();
				
				if(cur.left!=null && !isVisited.containsKey(cur.left)) {
					isVisited.put(cur.left, true);
					queue.add(cur.left);
				}
				
				if(cur.right!=null && !isVisited.containsKey(cur.right)) {
					isVisited.put(cur.right, true);
					queue.add(cur.right);
				}
				
				if(parentMap.get(cur)!=null && !isVisited.containsKey(parentMap.get(cur))) {
					isVisited.put(parentMap.get(cur), true);
					queue.add(parentMap.get(cur));
				}
					
				
			}
			
		}
		
		
		//store th remaining element in queue
		List<Integer> res = new ArrayList<>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			res.add(node.data);
			
		}
		
		System.out.println(res);
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		nodeatKdistance(root, root.left, 2);
		
	}

}
