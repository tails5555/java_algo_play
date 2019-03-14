package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D3 힙 문제 풀이
public class Main2930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < N; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                if (st.nextToken().equals("1")) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                } else {
                    if (!pq.isEmpty()) {
                        int tmp = pq.poll();
                        sb.append(String.format("%d ", tmp));
                    } else {
                        sb.append(String.format("%d ", -1));
                    }
                }
            }

            System.out.printf("#%d %s\n", k + 1, sb.toString());
        }
    }
}
