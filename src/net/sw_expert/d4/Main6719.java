package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D4 성수의 프로그래밍 강좌 시청
// 그리디 알고리즘에 대한 인지 여부를 물었던 문제
public class Main6719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            while(st.hasMoreTokens()){
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            double success = 0.0f;
            int[] tmp = new int[K];
            int idx = K - 1;
            while(idx >= 0){
                int a = pq.poll();
                tmp[idx] = a;
                idx -= 1;
            }
            for(int l = 0; l < K; l++){
                success = (success + tmp[l]) / 2.0;
            }

            System.out.printf("#%d %f\n", k+1, success);
        }
    }
}
