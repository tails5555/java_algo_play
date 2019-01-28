package net.hackerrank.search;

import java.util.HashMap;
import java.util.Map;

// Hacker Rank 탐색 문제
// Hash Tables: Ice Cream Parlor 문제
public class Example01 {
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        for(int k=0;k<cost.length;k++){
            int dist = cost[k] - money;
            if(map.containsKey(dist * (-1))) {
                start = map.get(dist * (-1));
                end = k;
                break;
            } else {
                map.put(cost[k], k);
            }
        }
        System.out.printf("%d %d\n", start + 1, end + 1);
    }

    public static void main(String[] args){
        whatFlavors(new int[] { 1, 4, 5, 3, 2 }, 4);
        whatFlavors(new int[] { 2, 2, 4, 3 }, 4);
        whatFlavors(new int[] { 2, 1, 3, 5, 6 }, 5);
    }
}
