package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Baekjoon KOI 2015 초등부 여왕벌 문제 풀이
public class Main18036 {
    static BufferedReader br;
    static StringTokenizer st;
    static int M, N;
    static int[][] map;
    static int[] dist;

    static void initialize() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        map = new int[M][M];
        for(int k = 0; k < M; k++){
            Arrays.fill(map[k], 1);
        }

        N = Integer.parseInt(st.nextToken());
        dist = new int[2 * M - 1];
    }

    static void first_logic() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        for(int k = 0; k < 3; k++){
            int cnt = Integer.parseInt(st.nextToken());
            for(int m = 0; m < cnt; m++){
                dist[idx] += k;
                idx += 1;
            }
        }
    }

    static void second_logic() {
        for(int k = 1; k <= dist.length; k++){
            int r = Math.max(M - k, 0);
            int c = Math.max(k - M, 0);
            map[r][c] += dist[k - 1];
        }
        for(int k = 1; k < M; k++){
            for(int l = 1; l < M; l++){
                map[k][l] = Math.max(map[k][l - 1], Math.max(map[k - 1][l], map[k - 1][l - 1]));
            }
        }
    }

    static void print() {
        for(int k = 0; k < map.length; k++){
            System.out.println(
                Arrays
                    .stream(map[k])
                    .mapToObj(v -> String.valueOf(v))
                    .collect(Collectors.joining(" "))
            );
        }
    }

    public static void main(String[] args) throws IOException {
        initialize();
        for(int k = 0; k < N; k++){
            first_logic();
        }
        second_logic();
        print();
    }
}
