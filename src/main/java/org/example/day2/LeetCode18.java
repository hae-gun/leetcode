package org.example.day2;

import java.math.BigDecimal;
import java.util.*;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        return kSum(nums, 0, 4, new BigDecimal(target));
    }

    public List<List<Integer>> kSum(int[] nums, int start, int k, BigDecimal target) {
        List<List<Integer>> res = new ArrayList<>();
        if(start == nums.length){
            return res;
        }

        boolean chk1 = new BigDecimal(nums[start]).multiply(new BigDecimal(k)).compareTo(target) > 0;
        boolean chk2 = new BigDecimal(nums[nums.length-1]).multiply(new BigDecimal(k)).compareTo(target) < 0;
        if (chk1 || chk2)
            return res;
        if (k==2) {
            return twoSum(nums, start, target);
        }

        for (int i=start; i<nums.length; i++) {
            if (i!=start && nums[i-1]==nums[i]) continue;
            for (var set : kSum(nums, i+1, k-1, target.subtract(new BigDecimal(nums[i])))) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size()-1).addAll(set);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, BigDecimal target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<BigDecimal> set = new HashSet<>();
        for (int i=start; i<nums.length; i++) {
            if (!res.isEmpty() && res.get(res.size()-1).get(1)==nums[i]) continue;
            BigDecimal complement = target.subtract(new BigDecimal(nums[i]));
            if (set.contains(complement))
                res.add(Arrays.asList(complement.intValue(), nums[i]));
            set.add(new BigDecimal(nums[i]));
        }
        return res;
    }
}
