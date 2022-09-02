package com.problems;

import java.lang.invoke.SerializedLambda;
import java.util.LinkedList;
import java.util.Queue;

public class Tree36SerializeandDeSerialize {
	
	private static String serializeTree(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode node = queue.poll();
			
			if(node==null) {
				sb.append("# ");
				continue;
			}
			
			sb.append(node.data+" ");
			queue.add(node.left);
			queue.add(node.right);
				
		}
		
		
		return sb.toString();
	}
	
	private static TreeNode deserializeTree(String data) {

		String[] str = data.split(" ");
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		queue.add(root);
		
		
		for(int i=1;i<str.length;i++) {
			
			TreeNode parent = queue.poll();
			
			if(!str[i].equals("#")) {
				
				TreeNode left = new TreeNode(Integer.parseInt(str[i]));
				parent.left = left;
				queue.add(left);
			}
			i++;
			if(!str[i].equals("#")) {
				
				TreeNode right = new TreeNode(Integer.parseInt(str[i]));
				parent.right = right;
				queue.add(right);
			}
			
		}
		
		return root;
		
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		String str = serializeTree(root);
		System.out.println("Serialized: "+str);
		TreeNode head = deserializeTree(str);
		System.out.println("Deserialized: "+head);

	}

}
