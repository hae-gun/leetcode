package org.example.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    // 백트래킹 이용
    List<List<String>> ret=new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[] ps=new int[n];
        Arrays.fill(ps,Integer.MIN_VALUE);
        solve(ps,n,n);
        return ret;
    }

    void solve(int[] ps,int n,int len){
        if(n==0){
            List<String> entry=new ArrayList<String>();
            for(int i=0;i<len;i++)
            {
                char[] s=new char[len];
                Arrays.fill(s,'.');
                s[ps[i]]='Q';
                entry.add(String.valueOf(s));
            }
            ret.add(entry);
        } else{
            for(ps[n-1]=len-1;ps[n-1]>=0;ps[n-1]--){
                int i=len;
                while(--i>n-1)
                    if(ps[i]==ps[n-1]||Math.abs(ps[i]-ps[n-1])==Math.abs(n-1-i))break;
                if(i>n-1){
                    continue;
                } else {
                    solve(ps,n-1,len);
                }
            }
        }
    }
}
