package org.example.week21;

import java.util.Arrays;

public class LeetCode135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length]; // 배열생성
        Arrays.fill(candy, 1); // 1초기화
        for (int i = 0; i < candy.length; i++) { // 순환
            if (i != 0 && ratings[i-1] > ratings[i]) { // 좌측
                candy[i-1] = candy[i] + 1;
            }
            if (i != candy.length - 1 && ratings[i] < ratings[i+1]) { // 우측
                candy[i+1] = candy[i] + 1;
            }
        }
        return Arrays.stream(candy).sum();
    }
}
