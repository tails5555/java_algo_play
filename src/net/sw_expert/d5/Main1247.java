package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D5 최적 경로 문제 풀이
public class Main1247 {
    static int N;
    static int distance;
    static int[] company, home;
    static int[][] request;
    static boolean[] visited;

    static void backtracking(int cnt, int idx, int dist){
        if(cnt == N){
            distance = Math.min(distance, dist + Math.abs(request[idx][0] - home[0]) + Math.abs(request[idx][1] - home[1]));
            return;
        }

        for(int k = 0; k < N; k++){
            if(!visited[k] && k != idx){
                visited[k] = true;
                backtracking(cnt + 1, k, dist + Math.abs(request[k][0] - request[idx][0]) + Math.abs(request[k][1] - request[idx][1]));
                visited[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            distance = Integer.MAX_VALUE;
            company = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            home = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            request = new int[N][2];
            visited = new boolean[N];
            for(int l = 0; l < N; l++){
                request[l] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            }

            for(int l = 0; l < N; l++){
                visited[l] = true;
                backtracking(1, l, Math.abs(company[0] - request[l][0]) + Math.abs(company[1] - request[l][1]));
                visited[l] = false;
            }

            System.out.printf("#%d %d\n", k + 1, distance);
        }
    }
}
