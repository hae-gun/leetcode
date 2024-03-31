package org.example.week17;

import org.example.week13.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(root.val);
        dfs ( root, targetSum - root.val, result, nums);

        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, ArrayList<Integer> nums) {

        if (root.right == null && root.left == null && targetSum == 0){
            result.add(nums);
            return;
        }



        if(root.right != null){
            ArrayList<Integer> otherNums = new ArrayList<>(nums);
            otherNums.add(root.right.val);
            dfs(root.right, targetSum - root.right.val, result, otherNums);
        }

        if(root.left != null){
            ArrayList<Integer> otherNums = new ArrayList<>(nums);
            otherNums.add(root.left.val);
            dfs(root.left, targetSum - root.left.val, result, otherNums);
        }
    }
}
