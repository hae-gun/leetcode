package org.example.day1;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LeetCode13Test {
    LeetCode13 solution = new LeetCode13();
//          roam.put("I",1);
//        roam.put("V",5);
//        roam.put("X",10);
//        roam.put("L",50);
//        roam.put("C",100);
//        roam.put("D",500);
//        roam.put("M",1000);
    @Test
    void test(){
        //"MCMXCIV"
        //Output: 1994
        int num =solution.romanToInt("MCMXCIV");
        System.out.println(num);
        assertThat(num).isEqualTo(1994);
        num =solution.romanToInt("DCCCXXXIX");
        assertThat(num).isEqualTo(839);
    }
}