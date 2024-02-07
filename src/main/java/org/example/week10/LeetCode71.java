package org.example.week10;

import java.util.*;

public class LeetCode71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        Deque<String> dq = new LinkedList<>();

        for(String p : paths){
            if("..".equals(p)){
                if(!dq.isEmpty()){
                    dq.removeLast();
                }
                continue;
            }
            if(".".equals(p)){
                continue;
            }
            if("".equals(p)){
                continue;
            }
            dq.add(p);
        }
        StringBuilder sb = new StringBuilder("/");
        while(!dq.isEmpty()){
            sb.append(dq.poll());
            if(!dq.isEmpty()){
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
