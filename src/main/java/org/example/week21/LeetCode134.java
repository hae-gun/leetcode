package org.example.week21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, start = 0, remaining = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            remaining += diff; // (1)
            total += diff; // (2)
            if (remaining < 0) { // (3)
                remaining = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1; // (4)
    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int idx = -1;
        int mapSize = gas.length;
        int curGas = -1;

        List<Integer> startPosition = new ArrayList<>();
        for(int i=0; i<mapSize; i++){
            if(gas[i] > cost[i]){
                idx = i;

                startPosition.add(i);
            }
        }
        if(idx == -1){
            return -1;
        }
        System.out.println(String.format("%d start ", idx));

        for(int i : startPosition){
            if(isCanAround(i, gas, cost)){
               return i;
            }
        }
        return -1;
    }

    private boolean isCanAround(int i, int[] gas, int[] cost) {
        int curGas = gas[i];
        boolean[] travled = new boolean[gas.length];
        int mapSize = gas.length;

        while(curGas >= cost[i]){
            int next = nextIdx(i, mapSize);

            travled[next] = true;
            System.out.println(String.format("Travel to station %d. Your tank = %d - %d + %d = %d", next,curGas, cost[i], gas[next],curGas - cost[i] + gas[next] ));
            curGas = curGas - cost[i] + gas[next];
            i = next;
            if(checkTravled(travled)){
                break;
            }
        }

        return checkTravled(travled);
    }

    public int nextIdx(int curIdx, int mapSize){
        curIdx += 1;
        if(curIdx > mapSize-1){
            return 0;
        }
        return curIdx;
    }
    private boolean checkTravled(boolean[] travled){
        // System.out.println(Arrays.toString(travled));
        for(boolean b : travled){
            if(!b) return false;
        }
        return true;
    }
}
