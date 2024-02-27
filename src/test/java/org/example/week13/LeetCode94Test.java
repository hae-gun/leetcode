package org.example.week13;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
class LeetCode94Test {

    LeetCode94 solution = new LeetCode94();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,null,2,3:1,3,2" , "1:1", " : "},delimiter = ':')
    public void test(String input, String result){
        TreeNode node = new TreeNode();
        if(input == null){
            node =  null;
        } else {
            List<String> collect = Arrays.stream(input.split(",")).toList();
            int n = 0;

            while((int)Math.pow(2, n) < collect.size()){
                n++;
            }
            for(int i=0; i<=n; i++){
                if(i == 0){
                    node = new TreeNode(Integer.parseInt(collect.get(i)));
                }else{
                    for(int j=(int)Math.pow(2, i-1); j<(int)Math.pow(2, i); j++){

                    }
                }
            }
        }
        List<Integer> results;
        if(result == null){
            results = new ArrayList<>();
        }else{
            results = Arrays.stream(result.split(",")).mapToInt(Integer::valueOf).boxed().toList();
        }

        assertThat(solution.inorderTraversal(node)).containsExactlyElementsOf(results);

    }

}