package org.example.week19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        getRow(result, rowIndex);
        return result;
    }
    private void getRow(List<Integer> list, int index){
        if(index == 0) list.add(1);
        else if(index == 1){
            Integer[] arr = {1, 1};
            list.addAll(Arrays.asList(arr));
        }else{
            getRow(list, index - 1);
            Integer[] res = new Integer[index + 1];
            res[0] = 1; res[index] = 1;
            for(int i = 1; i < index; i++){
                res[i] = list.get(i) + list.get(i - 1);
            }
            list.clear();
            list.addAll(Arrays.asList(res));
        }
    }
}
