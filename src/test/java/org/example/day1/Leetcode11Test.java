package org.example.day1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode11Test {
    Leetcode11 solution = new Leetcode11();

    @Test
    void test(){
        solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}