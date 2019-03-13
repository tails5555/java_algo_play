package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// SW Expert D3 문제 제목 붙이기 문제 풀이
public class Main7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            char start = 'A';
            PriorityQueue<String> pq = new PriorityQueue<>();
            for(int l = 0; l < N; l++){
                pq.offer(br.readLine());
            }

            while(!pq.isEmpty()) {
                String tmp = pq.poll();
                if(tmp.charAt(0) == start){
                    start += 1;
                }
            }
            System.out.printf("#%d %d\n", k + 1, start - 'A');
        }
    }
}
