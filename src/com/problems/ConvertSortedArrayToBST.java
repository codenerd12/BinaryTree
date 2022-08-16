package com.problems;

public class ConvertSortedArrayToBST {
	
	public static TreeNode convertBST(int[] nums, int lw, int up) {
        
        if(lw>up)
            return null;
        
        int mid = (lw+up)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = convertBST(nums, lw, mid-1);
        root.right = convertBST(nums, mid+1, up);
        
        return root;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-10,-3,0,5,9};
		int lw = 0;
	    int up = nums.length-1;
		TreeNode root  = convertBST(nums, lw, up);
		System.out.println(root);

	}

}
