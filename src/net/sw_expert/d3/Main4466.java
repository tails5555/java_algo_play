package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D3 최대 성적표 만들기 문제 풀이
public class Main4466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens())
                pq.offer(Integer.parseInt(st.nextToken()));

            int sum = 0;
            int cnt = 0;
            while(cnt < M) {
                int tmp = pq.poll();
                sum += tmp;
                cnt++;
            }

            System.out.printf("#%d %d\n", k+1, sum);
        }
    }
}
