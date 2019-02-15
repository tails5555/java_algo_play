package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 부분 수열의 합 문제 풀이
public class Main2817 {
    static int[] arr;
    static boolean[] visited;
    static int K;
    static int cnt;
    static void backtracking(int idx, int sum) {
        if(sum > K) return;
        else if(K == sum) {
            cnt += 1;
        } else {
            for(int k = idx; k < arr.length; k++){
                if(!visited[k]) {
                    visited[k] = true;
                    backtracking(k, sum + arr[k]);
                    visited[k] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[Integer.parseInt(st.nextToken())];
            visited = new boolean[arr.length];
            K = Integer.parseInt(st.nextToken());
            cnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens())
                arr[idx++] = Integer.parseInt(st.nextToken());

            backtracking(0, 0);
            System.out.printf("#%d %d\n", k+1, cnt);
        }
    }
}
