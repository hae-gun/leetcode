package org.example.week16;

import org.example.week13.TreeNode;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.genTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode genTree(int[] preorder, int[] inorder, int preorderIndex, int inorderStartIndex, int inorderEndIndex) {
        if (preorderIndex >= preorder.length || inorderStartIndex > inorderEndIndex) return null;

        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = 0;
        for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
            if (inorder[i] == node.val) {
                inorderIndex = i;
                break;
            }
        }

        node.left = this.genTree(preorder, inorder, preorderIndex + 1, inorderStartIndex, inorderIndex - 1);
        node.right = this.genTree(preorder, inorder, preorderIndex + inorderIndex - inorderStartIndex + 1, inorderIndex + 1, inorderEndIndex);

        return node;
    }
}
