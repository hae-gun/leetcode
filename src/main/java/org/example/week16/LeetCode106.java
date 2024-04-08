package org.example.week16;

import org.example.week13.TreeNode;

public class LeetCode106 {
    int postIndex ;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length ;
        if(n == 0)return null;
        if(n == 1 )return new TreeNode(inorder[0]);
        postIndex = n-1;
        return helper(inorder, postorder, 0, n-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(start  > end  || postIndex<0) return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int rootIndex = findN(inorder, root.val);

        root.right = helper(inorder, postorder, rootIndex+1, end);
        root.left = helper(inorder, postorder, start, rootIndex-1);

        return root;
    }
    public int findN(int[] arr, int key){
        for(int i = 0 ;i < arr.length ;i++){
            if(arr[i] == key)return i;
        }
        return -1;
    }
}
