package org.example.week14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class LeetCode97Test {
    LeetCode97 solution = new LeetCode97();
    @ParameterizedTest(name = "{index} {displayName} s={0}, output={1}")
    @CsvSource(value = {"aabcc:dbbca:aadbbcbcac:true","aabcc:dbbca:aadbbbaccc:false",":::true","a:b:a:false", "aa:ab:abaa:true"},delimiter = ':')
    void test(String s1, String s2, String s3, boolean result) {
        if(s1 == null){
            s1 = "";
        }
        if(s2 == null){
            s2 = "";
        }
        if(s3 == null){
            s3 = "";
        }
        assertThat(solution.isInterleave(s1, s2, s3)).isEqualTo(result);
    }
}