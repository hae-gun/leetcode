package org.example.week5;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> resultStr = new HashSet<>();
        Arrays.sort(candidates);
        backtracking(resultStr,new ArrayList<>(),candidates,target,0);
        ArrayList<String> strings = new ArrayList<>(resultStr);
        Collections.sort(strings);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(String str : strings){
            result.add(Arrays.stream(str.split("")).map(Integer::valueOf).toList());
        }
        return result;
    }

    public void backtracking(Set<String> result, List<Integer> comb, int[] nums, int target, int start){
        //end case
        if(target == 0){
            result.add(String.join("", comb.stream().sorted().map(String::valueOf).toArray(String[]::new)));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(nums[i] > target) break;
            comb.add(nums[i]);
            backtracking(result,comb,nums,target - nums[i],0);
            comb.remove(comb.size()-1);
        }
    }
}
