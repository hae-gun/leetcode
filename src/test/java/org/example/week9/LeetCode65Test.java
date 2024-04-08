package org.example.week9;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode65Test {
    LeetCode65 solution = new LeetCode65();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2:true", "0089:true", "-0.1:true", "+3.14:true", "4.:true", "-.9:true", "2e10:true", "-90E3:true", "3e+7:true", "+6e-1:true", "53.5e93:true", "-123.456e789:true","abc:false", "1a:false", "1e:false", "e3:false", "99e2.5:false", "--6:false", "-+3:false", "95a54e53:false","44e016912630333:true","7e69e:false"},delimiter = ':')
    void test(String numstr, boolean result){
        assertThat(solution.isNumber(numstr)).isEqualTo(result);
    }
}
