package org.example.week9;

import java.util.ArrayList;
import java.util.List;

public class LeetCode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        int idx = 0;
        List<String>
        for(String word : words){
            idx += word.length();

            if(idx > maxWidth){
                list.add(temp.toString());
                temp = new StringBuilder();
                idx = 0;
                continue;
            }

        }



        return list;
    }
}
