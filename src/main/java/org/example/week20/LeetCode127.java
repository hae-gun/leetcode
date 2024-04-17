package org.example.week20;

import java.util.*;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( wordList == null || wordList.size() == 0 )
            return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        int l = endWord.length();

        while( !q.isEmpty() ){
            level++;
            int size = q.size();
            for( int i = 0; i < size; i++ ){
                String str = q.poll();
                for( char c = 'a'; c <= 'z'; c++ ){
                    for( int j = 0; j < l; j++ ){
                        // better way to change letter
                        char[] word = str.toCharArray();
                        word[j] = c;
                        String newStr = new String(word);
                        if( wordSet.contains(newStr) ){
                            if( newStr.equals(endWord) )
                                return level;
                            q.offer(newStr);
                            wordSet.remove(newStr);    // avoid visiting again, avoid deal loop
                        }
                    }
                }
            }
        }
        return 0;
    }
}
