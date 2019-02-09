package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D2 조교의 성적 매기기 문제
public class Main1983 {
    static final String[] score = new String[] { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int pivot = N / 10;
            int myScore = 0;
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int tmpScore = Integer.parseInt(st.nextToken()) * 35 + Integer.parseInt(st.nextToken()) * 45 + Integer.parseInt(st.nextToken()) * 20;
                if(l == K - 1) {
                    myScore = tmpScore;
                }
                pq.offer(tmpScore);
            }

            int idx = 0;
            while(!pq.isEmpty()){
                int tmp = pq.poll();
                if(myScore == tmp) break;
                idx += 1;
            }

            System.out.printf("#%d %s\n", k+1, score[idx / pivot]);
        }
    }
}
