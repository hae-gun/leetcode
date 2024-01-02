package org.example.week5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode58{
        public int lengthOfLastWord(String s) {
            String[] words = s.split(" ");
            List<String> list = Arrays.stream(words).filter(v -> !"".equals(v))
                    .toList();
            return list.get(list.size()-1).length();
        }
}
