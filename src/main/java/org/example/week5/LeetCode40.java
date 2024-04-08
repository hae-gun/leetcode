package org.example.week5;

import java.util.*;

public class LeetCode40 {
    private Set<List<Integer>> listSet = new HashSet<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<List<Integer>>(listSet);
        }
        Arrays.sort(candidates);
        combination(new ArrayList<>(), candidates, 0, target);

        return new ArrayList<List<Integer>>(listSet);
    }

    public void combination(List<Integer> combis, int[] candidates, int inx, int target){

        if(target < 0){
            return;
        }

        if(target == 0){
            listSet.add(combis);
            return ;
        }

        for(int i=inx; i<candidates.length; i++){
            if(i > inx && candidates[i] == candidates[i - 1]) continue;
            if(target - candidates[i] < 0) return;
            combis.add(candidates[i]);
            combination(new ArrayList<Integer>(combis), candidates, i+1, target - candidates[i]);
            combis.remove(combis.size()-1);
        }
    }
}
