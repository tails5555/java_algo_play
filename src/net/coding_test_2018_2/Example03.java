package net.coding_test_2018_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 프로그래머스 2018 하반기 모의고사 3번
// 버스 여행 문제 - BFS / DFS 활용 문제
public class Example03 {
    static int[][] solution(int[][] sign, int N){
        int[][] result = new int[N][N];

        // 시간 복잡도는 적어도 O(V^2) 이지만 더욱 효율적으로 정점 목록을 가져오기 위해 사전에 Map 을 이용해서 정리합니다!
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int k=0;k<sign.length;k++){
            Set<Integer> tmp = map.getOrDefault(sign[k][0], new HashSet<>());
            tmp.add(sign[k][1]);
            map.put(sign[k][0], tmp);
        }

        for(int k=1;k<=N;k++){
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(k);
            Set<Integer> visited = new HashSet<>();
            while(!queue.isEmpty()) {
                int tmp = queue.poll();
                for(int v : map.getOrDefault(tmp, new HashSet<>())) {
                    if(!visited.contains(v)) {
                        visited.add(v);
                        queue.offer(v);
                    }
                }
            }

            for(int v : visited) {
                result[k - 1][v - 1] = 1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] result1 = solution(
            new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 6 }, { 6, 5 } }, 7
        );
        for(int k = 0; k < result1.length; k++) {
            System.out.println(Arrays.toString(result1[k]));
        }
        int[][] result2 = solution(
            new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } }, 3
        );
        for(int k = 0; k < result2.length; k++) {
            System.out.println(Arrays.toString(result2[k]));
        }
    }
}
