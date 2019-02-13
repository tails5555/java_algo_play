package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 민식Yee의 과제 체크하기 문제 풀이
public class Main5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            boolean[] checked = new boolean[N + 1];
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(idx < M){
                checked[Integer.parseInt(st.nextToken())] = true;
                idx += 1;
            }
            StringBuilder sb = new StringBuilder();
            for(int l = 1; l <= N; l++){
                if(!checked[l])
                    sb.append(String.format("%d ", l));
            }
            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
