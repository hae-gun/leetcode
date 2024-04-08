package org.example.week11;

import java.util.*;

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {

        Set<NumberSetList> result = new HashSet<>();

        makeSubSet(result, nums, new ArrayList<>(), 0);
        List<List<Integer>> answerList = new ArrayList<>();

        for(NumberSetList s : result){
            answerList.add(s.getMyList());
        }


        return answerList;
    }

    private void makeSubSet(Set<NumberSetList> result, int[] nums, List<Integer> list, int dept) {
        result.add(new NumberSetList(list));

        if(dept >= nums.length) return;
        list.add(nums[dept]);
        makeSubSet(result, nums, new ArrayList<>(list), dept+1);
        list.remove(list.size()-1);
        makeSubSet(result, nums, new ArrayList<>(list), dept+1);
    }


    class NumberSetList {

        private List<Integer> myList;

        public NumberSetList(List<Integer> myList) {
            this.myList = myList;
        }

        public void addNum (int num){
            myList.add(num);
        }
        public List<Integer> getMyList() {
            return myList;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NumberSetList that = (NumberSetList) o;
            return myList.containsAll(that.getMyList());
        }

        @Override
        public int hashCode() {
            return Objects.hash(myList);
        }

        @Override
        public String toString() {
            return myList.toString();
        }
    }
}
