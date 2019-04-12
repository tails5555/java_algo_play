package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// SW Expert D5 K 번째 접미어 문제 풀이
public class Main1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            char[] m = br.readLine().toCharArray();
            PriorityQueue<String> pq = new PriorityQueue<>();
            for(int l = 0; l < m.length; l++){
                pq.offer(new String(Arrays.copyOfRange(m, l, m.length)));
            }

            String res = "";
            int idx = 0;
            while(!pq.isEmpty()){
                String tmp = pq.poll();
                idx += 1;
                if(idx == N) {
                    res = tmp;
                    break;
                }
            }

            System.out.printf("#%d %s\n", k + 1, res);
        }
    }
}
