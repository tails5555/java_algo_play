package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baekjoon 신입사원 문제 풀이
public class Main1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else return o1[1] - o2[1];
            });

            StringTokenizer st;
            for(int l=0;l<N;l++){
                st = new StringTokenizer(br.readLine(), " ");
                int score = Integer.parseInt(st.nextToken());
                int rank = Integer.parseInt(st.nextToken());
                pq.offer(new int[] { score, rank });
            }

            int cnt = 0;
            int tmp = Integer.MAX_VALUE;
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                if(tmp > cur[0]) {
                    tmp = cur[0];
                    cnt += 1;
                }
            }

            bw.write(String.format("%d\n", cnt));
        }

        bw.flush();
    }
}
