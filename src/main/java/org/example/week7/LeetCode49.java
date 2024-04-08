package org.example.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        List<List<String>> answer = new ArrayList<>();

        for(String nowString: strs){
            char[] chr = nowString.toCharArray();
            Arrays.sort(chr);
            String sortedString = String.valueOf(chr);

            if(!map.containsKey(sortedString)){
                List<String> set = new ArrayList<>();
                set.add(nowString);
                map.put(sortedString, set);
            }
            else{
                map.get(sortedString).add(nowString);
            }
        }

        map.forEach((key, value) -> {
            answer.add(value);
        });

        return answer;
    }
}
