package com.problems;

import java.util.HashMap;
import java.util.Map;

public class PostByInorderandPreorder {
	
	
	static void printPostOrderTraversal(int in[], int[] pre, Map<Integer, Integer> inMap, int inStart, int inEnd, int[] idx) {
        
        if(inStart > inEnd)
            return;
        
        if(inStart == inEnd) {
        	idx[0]++;
            System.out.print(in[inStart]+" ");
            return;
        }
        
        int ele = pre[idx[0]++];
        int ind = inMap.get(ele);
    
        printPostOrderTraversal(in, pre, inMap, inStart, ind-1, idx);
        //System.out.print(ele+" ");
        printPostOrderTraversal(in, pre, inMap, ind+1, inEnd, idx);
        //System.out.print(ele+" ");
        
        
        System.out.print(ele+" ");
    }
    
	static void printPostOrder(int in[], int pre[])
	{
		// Your code here
		Map<Integer, Integer> inMap = new HashMap<>();
		
		for(int i=0;i<in.length;i++)
		    inMap.put(in[i], i);
		    
	    printPostOrderTraversal(in, pre, inMap, 0, in.length-1, new int[]{0});
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inorder = {10, 1, 30, 40, 20};
		int[] preorder = {1, 10, 20, 30, 40};
		
		printPostOrder(inorder, preorder);

	}

}
