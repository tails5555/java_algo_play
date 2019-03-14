package net.sw_expert.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D6 사람 네트워크2 문제 풀이
public class Main1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());

            Set<Integer>[] sets = new Set[N + 1];
            for(int l = 1; l <= N; l++){
                sets[l] = new HashSet<>();
            }

            for(int l = 1; l <= N; l++){
                for(int m = 1; m <= N; m++){
                    int t = Integer.parseInt(st.nextToken());
                    if(t == 1) {
                        sets[l].add(m);
                        sets[m].add(l);
                    }
                }
            }

            Queue<int[]> queue;
            Set<Integer> visited;
            int count = Integer.MAX_VALUE;
            for(int l = 1; l <= N; l++){
                queue = new LinkedList<>();
                visited = new HashSet<>();

                queue.offer(new int[] { l, 0 });
                visited.add(l);

                int cnt = 0;
                while(!queue.isEmpty()) {
                    int[] tmp = queue.poll();
                    for(int t : sets[tmp[0]]) {
                        if(!visited.contains(t)){
                            cnt += (tmp[1] + 1);
                            queue.add(new int[] { t, tmp[1] + 1 });
                            visited.add(t);
                        }
                    }
                }

                count = Math.min(count, cnt);
            }

            System.out.printf("#%d %d\n", k + 1, count);
        }
    }
}
