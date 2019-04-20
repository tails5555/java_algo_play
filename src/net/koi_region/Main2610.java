package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Baekjoon 2610 번 KOI 2004 지역본선 중등부 3번 회의 준비 문제 풀이
// 다행히도 N 은 작은 값(100) 이라서 플로이드 워샬 알고리즘이면 충분하다.
public class Main2610 {
    static final int MAX = 987654321;

    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static int[][] froyd;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        froyd = new int[N + 1][N + 1];
        for(int k = 0; k < froyd.length; k++){
            Arrays.fill(froyd[k], MAX);
            froyd[k][k] = 0;
        }

        int M = Integer.parseInt(br.readLine());
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            froyd[from][to] = froyd[to][from] = 1;
        }
    }

    static void solution() {
        for(int m = 1; m <= N; m++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    froyd[a][b] = Math.min(froyd[a][b], froyd[a][m] + froyd[m][b]);
                }
            }
        }

        List<Integer> leader = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        int[] sum = new int[N + 1];

        int cnt = 0;
        for(int k = 1; k <= N; k++){
            if(!visited[k]) cnt++;
            int max = 0;
            for(int l = 1; l <= N; l++){
                if(froyd[k][l] == MAX) continue;
                visited[l] = true;
                max = Math.max(froyd[k][l], max);
            }
            sum[k] = max;
        }
        Arrays.fill(visited, false);

        for(int k = 1; k <= N; k++){
            if(!visited[k]) {
                visited[k] = true;
                int min = MAX + 1;
                int tmp = k;
                for(int l = 1; l <= N; l++){
                    if(k != l && froyd[k][l] != MAX){
                        visited[l] = true;
                        if(min > sum[l]){
                            tmp = l;
                            min = sum[l];
                        }
                    }
                }
                leader.add(tmp);
            }
        }

        System.out.println(cnt);
        Collections.sort(leader);
        for(int k : leader){
            System.out.println(k);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
