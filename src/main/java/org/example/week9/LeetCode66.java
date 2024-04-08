package org.example.week9;

import java.math.BigDecimal;
import java.util.Arrays;

public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();

        for(int digit : digits){
            sb.append(String.valueOf(digit));
        }

        BigDecimal bd = new BigDecimal(sb.toString());

        bd = bd.add(BigDecimal.ONE);

        return Arrays.stream(bd.toString().split("")).mapToInt(Integer::parseInt).toArray();
    }
}
