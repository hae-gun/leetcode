package org.example.week13;

import java.util.*;

public class LeetCode90 {
    public static void main(String[] args) {
        LeetCode90 l = new LeetCode90();
        List<List<Integer>> lists = l.subsetsWithDup(new int[]{1,5,3});
        System.out.println(lists);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<ArrayList<Integer>> ss = new HashSet<ArrayList<Integer>>();

        // assuming |nums|<=32
        for (int i = 0; i < (1<<nums.length); i++){
            int j = i;
            int n = 0;
            ArrayList<Integer> s = new ArrayList<Integer>();
            while(j != 0){
                if ((j & 1) == 1){
                    s.add(nums[n]);
                }
                j >>= 1;
                n++;
            }
            ss.add(s);
        }
        return new ArrayList<>(ss);
    }

    public List<List<Integer>> subsetsWithDupX(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        subset(set, new boolean[nums.length], nums, 0);

        ArrayList<List<Integer>> lists = new ArrayList<>(set);

        Collections.sort(lists, (a, b) -> {
            if (a.isEmpty() && !b.isEmpty()) {
                return -1;
            } else if (!a.isEmpty() && b.isEmpty()) {
                return 1;
            }
            // 첫번째 원소가 작은 순으로 정렬합니다.
            if (!a.isEmpty() && !b.isEmpty()) {
                int firstElementComparison = Integer.compare(a.get(0), b.get(0));
                if (firstElementComparison != 0) {
                    return firstElementComparison;
                }
            }
            // 길이가 같으면 기존 순서 유지합니다.
            return 0;
        });
        return lists;
    }

    private void subset(Set<List<Integer>> set, boolean[] used,int[] nums, int dept) {
        if(dept == nums.length){
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < used.length; i++) {
                if(used[i]) list.add(nums[i]);
            }
            set.add(list);
            return;
        }

        for(int i=dept; i<nums.length; i++){
            used[i] = true;
            subset(set, used, nums, dept+1);
            used[i] = false;
        }

    }

}
