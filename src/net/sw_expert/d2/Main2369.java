package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 Theater 문제 풀이
public class Main2369 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                cnt += (Math.abs(from - to) + 1);
            }
            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}
