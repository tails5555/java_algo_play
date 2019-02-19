package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D4 길찾기 문제 풀이
public class Main1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k = 0; k < 10; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int test = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            Map<Integer, Set<Integer>> map = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if(start < end){
                    Set<Integer> set = map.getOrDefault(start, new HashSet<>());
                    set.add(end);
                    map.put(start, set);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            boolean[] visited = new boolean[100];
            visited[0] = true;
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                if(map.containsKey(tmp)) {
                    for (int other : map.get(tmp)) {
                        if(!visited[other]) {
                            queue.offer(other);
                            visited[other] = true;
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", test, visited[99] ? 1 : 0);
        }
    }
}
