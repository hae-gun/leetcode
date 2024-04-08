package org.example.week1;

import java.util.*;

public class LeetCode13 {
    private static Map<String, Integer> roam = new HashMap();
    static{
        roam.put("I",1);
        roam.put("V",5);
        roam.put("X",10);
        roam.put("L",50);
        roam.put("C",100);
        roam.put("D",500);
        roam.put("M",1000);
    }
    public int romanToInt(String s) {
        int result = 0;

        String[] sArr = s.split("");
        List<Integer> list = new ArrayList<>();
        for(int i=sArr.length - 1; i > -1; i--){
            list.add(roam.get(sArr[i]));
        }
//        System.out.println(list);

        int sum = list.get(0);
        for (int i = 0; i < list.size()-1; i++) {
            int num = list.get(i);
            int numN = list.get(i+1);
            if (sum > numN && num > numN) {
                sum -= numN;
            } else {
                sum += numN;
            }
        }
        return sum;
    }
}
