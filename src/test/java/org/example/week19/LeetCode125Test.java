package org.example.week19;

import org.example.week13.TreeNode;
import org.example.week15.LeetCode103;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode125Test {
    LeetCode125 solution = new LeetCode125();
    @ParameterizedTest(name = "{index} {displayName} s={0}, output={1}")
    @CsvSource(value = {"A man, a plan, a canal: Panama:true","race a car:false","\\ :true","0P:false"},delimiter = ':')
    void test(String s , boolean result){
        assertThat(solution.isPalindrome(s)).isEqualTo(result);
    }
}