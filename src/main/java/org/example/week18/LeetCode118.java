package org.example.week18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if(numRows == 0) return result;
        generate(result, numRows);
        return result;
    }
    private void generate(List<List<Integer>> result, int index){
        if(index == 1){
            result.add(Arrays.asList(1));
        }else if(index == 2){
            generate(result, index - 1);
            result.add(Arrays.asList(1, 1));
        }else{
            generate(result, index - 1);
            List<Integer> last = result.get(result.size() - 1);
            Integer[] current = new Integer[index];
            current[0] = 1; current[index - 1] = 1;
            for(int i = 1; i < index - 1; i++){
                current[i] = last.get(i) + last.get(i - 1);
            }
            result.add(Arrays.asList(current));
        }
    }
}
