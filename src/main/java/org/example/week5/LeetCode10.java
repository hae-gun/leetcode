package org.example.week5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        while(p.contains("**")){
            p = p.replaceAll("\\*\\*", "\\*");
        }
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
