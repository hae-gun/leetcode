package org.example.week20;

import java.util.HashSet;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        // edge case
        if( nums == null || nums.length == 0 ) return 0;

        HashSet<Integer> set = new HashSet<>();
        for( int i : nums ) set.add(i);
        int res = 0;

        for( Integer item : set ){
            if( set.contains(item-1) )  //只要有比该元素还小的元素，我们就跳过该元素，直到遇到
                continue;               //直到这个consecutive list的首元素，再统计长度；以防止重复统计。
            else{
                int sum = 1;            //没有我该元素小的，表明这是首元素，统计长度
                int next = item+1;
                while( set.contains(next) ){
                    sum++;
                    next++;
                }
                res = Math.max( res, sum );
            }
        }

        return res;
    }
}
