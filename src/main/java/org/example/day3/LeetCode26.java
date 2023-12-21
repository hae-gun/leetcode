package org.example.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet();
        int result = 0;
        for(int i=0; i < size; i++){
            if(set.contains(nums[i])) result ++;
            set.add(nums[i]);
        }
        List<Integer> resultList = new ArrayList<>(set);
        resultList.sort(Integer::compareTo);
        for(int i=0; i<resultList.size(); i++){
            nums[i] = resultList.get(i);
        }

        return resultList.size();
    }
}
