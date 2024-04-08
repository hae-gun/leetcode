package org.example.week10;

public class LeetCode69 {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        double s =  x / 2;
        double t = 0;
        for(; s!= t;){
            t = s;
            s = ((x/t) + t) / 2;
        }
        return (int)s;
    }
}
