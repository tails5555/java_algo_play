package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D3 나라시 까기 문제 풀이
public class Main1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k = 0; k < 10; k++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            while(st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            while(cnt < N) {
                int max = pq.poll();
                int min = Integer.MAX_VALUE;
                for(int a : pq)
                    min = Math.min(min, a);
                pq.remove(min);
                min += 1;
                max -= 1;
                pq.offer(min);
                pq.offer(max);
                cnt += 1;
            }

            int min = Integer.MAX_VALUE;
            for(int a : pq)
                min = Math.min(min, a);

            System.out.printf("#%d %d\n", k+1, Math.abs(min - pq.peek()));
        }
    }
}
