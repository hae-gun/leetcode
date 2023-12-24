package org.example.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> inputSubStrings = new HashMap();

        //1. Base case, if input of words is empty then nothing to compare
        if (words.length == 0) {
            return null;
        }

        //2. create map/dictionary of given words and their count
        for (String word : words) {
            inputSubStrings.put(word, inputSubStrings.getOrDefault(word, 0) + 1);
        }



        List<Integer> result = new ArrayList();

        //number of words in the words array
        int wordsCount = words.length;

        //words of the same length.
        int wordLength = words[0].length();

        int totalCharCount = wordsCount * wordLength;
        int len = s.length();

        //3. Loop to check with range of no of total characters from input words(s length - total char count
        for (int i = 0; i <= len - totalCharCount; i++) {
            //Map to check if we have already encountered the word
            Map<String, Integer> currentWordDict = new HashMap();

            //4. Loop to check each given sub string
            for (int j = 0; j < wordsCount; j++) {// Time complexity: O(i * j)
                //skipping the words and keeping our index pointer at the start of next word
                int nextWordIndex = i + j * wordLength;
                String nextWord = s.substring(nextWordIndex, nextWordIndex + wordLength);

                //I. skip if the next set of chars not matching with any of the given sub strings
                if (!inputSubStrings.containsKey(nextWord)) {
                    break;
                }
                //put or increment the current word counter
                currentWordDict.put(nextWord, currentWordDict.getOrDefault(nextWord, 0) + 1);

                //II. skip if current word frequency greater or not matching with input words frequency
                if (currentWordDict.get(nextWord) > inputSubStrings.getOrDefault(nextWord, 0)) {
                    break;
                }

                //on end of total no of words put current the index in result
                if (j + 1 == wordsCount) {
                    System.out.println(i);
                    result.add(i);
                }
            }
        }
        return result;
    }
}
