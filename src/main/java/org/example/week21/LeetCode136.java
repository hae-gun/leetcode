package org.example.week21;

import java.util.HashSet;
import java.util.Set;

public class LeetCode136 {
    public int singleNumber(int[] nums) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)){
                continue;
            }
            if(!result.contains(n) && !set.contains(n)){
                result.add(n);
                continue;
            }
            if(result.contains(n) && !set.contains(n)){
                result.remove(n);
                set.add(n);
            }
        }
        return result.stream().toList().get(0);
    }
}
