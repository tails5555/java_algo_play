package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 다시 풀어야 함...
// Baekjoon KOI 2016 초등부 장애물 경기 문제 풀이
// 맞게 푼거 같은데 왜 틀렸습니다가 나올까...
public class Main13303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int fromY = Integer.parseInt(st.nextToken());
        int toX = Integer.parseInt(st.nextToken());

        int[][] obstacles = new int[N][3];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            obstacles[k] = new int[] { x, y1, y2 };
        }
        Arrays.sort(obstacles, Comparator.comparingInt(o -> o[0]));

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, fromY, 0 });
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if(tmp[2] > res) continue;
            if(tmp[0] >= N) {
                Set<Integer> set = map.getOrDefault(tmp[2] + toX, new TreeSet<>());
                set.add(tmp[1]);
                map.put(tmp[2] + toX, set);
                res = Math.min(res, tmp[2] + toX);
            } else {
                int[] obstacle = obstacles[tmp[0]];
                if (tmp[1] >= obstacle[1] && tmp[1] <= obstacle[2]) {
                    if(Math.abs(tmp[1] - obstacle[1]) == Math.abs(tmp[1] - obstacle[2])) {
                        queue.offer(new int[]{ tmp[0] + 1, obstacle[1], tmp[2] + Math.abs(tmp[1] - obstacle[1]) });
                        queue.offer(new int[]{ tmp[0] + 1, obstacle[2], tmp[2] + Math.abs(tmp[1] - obstacle[2]) });
                    } else {
                        if(Math.abs(tmp[1] - obstacle[1]) < Math.abs(tmp[1] - obstacle[2])) {
                            queue.offer(new int[]{ tmp[0] + 1, obstacle[1], tmp[2] + Math.abs(tmp[1] - obstacle[1]) });
                        } else {
                            queue.offer(new int[]{ tmp[0] + 1, obstacle[2], tmp[2] + Math.abs(tmp[1] - obstacle[2]) });
                        }
                    }
                } else {
                    queue.offer(new int[]{ tmp[0] + 1, tmp[1], tmp[2] });
                }
            }
        }

        System.out.println(res);
        Set<Integer> set = map.get(res);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d ", set.size()));
        for(int s : set){
            sb.append(String.format("%d ", s));
        }
        System.out.println(sb.toString());
    }
}
