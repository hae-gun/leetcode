package org.example.week20;

import java.util.*;

public class LeetCode126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        if( wordList == null || wordList.size() == 0 )
            return res;

        // used to lookup if one word having 'edge' to another word, Set is O(1) for lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if( !wordSet.contains(endWord) )
            return res;

        Queue<List<String>> q = new LinkedList<>();
        List<String> prefix = new ArrayList<>();
        prefix.add(beginWord);
        q.offer(prefix);
        int l = beginWord.length();
        boolean breakFlag = false;

        while( !q.isEmpty() ){
            Set<String> toBeDeleted = new HashSet<>();
            int size = q.size();                        // handle by level
            for( int i = 0; i < size; i++ ){            // deal with last level's nodes (path)
                List<String> curPrefix = q.poll();      // get the path
                String last = curPrefix.get(curPrefix.size()-1);      // get path's last word
                char[] chars = last.toCharArray();      // convert to char[]
                for( int j = 0; j < l; j++ ){           // find if this last word has adjacent nodes
                    for( char c = 'a'; c <= 'z'; c++ ){
                        char old = chars[j];
                        chars[j] = c;
                        String newLast = new String(chars);
                        if( wordSet.contains(newLast) ){    // check if has this new word
                            toBeDeleted.add(newLast);       // if have, store it for later deletion
                            List<String> newPrefix = new ArrayList<>(curPrefix);
                            newPrefix.add(newLast);         // update prefix path
                            if( newLast.equals(endWord) ){  // check if we meet the endWord
                                res.add(new ArrayList<>(newPrefix) );
                                breakFlag = true;
                            }
                            q.offer(new ArrayList<>(newPrefix) );
                        }
                        chars[j] = old;                       // change back for next modification
                    }
                }
            }
            // after handling current level's node, if endWord resides on this level, terminate loop
            if( breakFlag )  return res;

            // delete words in toBeDeleted from wordSet
            wordSet.removeAll(toBeDeleted);
        }

        return res;
    }

}
