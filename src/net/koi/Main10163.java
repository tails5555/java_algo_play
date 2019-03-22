package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2014 초등부 색종이 문제 풀이
// width 가 100 * 100 이어서 굳이 세그먼트 트리까진 안 써도 되는 문제.
public class Main10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];
        for(int k = 1; k <= N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int ty = y; ty < y + height; ty++) {
                for (int tx = x; tx < x + width; tx++) {
                    map[ty][tx] = k;
                }
            }
        }

        int[] res = new int[N + 1];
        for(int k = 0; k < 101; k++){
            for(int l = 0; l < 101; l++){
                res[map[k][l]] += 1;
            }
        }

        for(int k = 1; k <= N; k++){
            System.out.println(res[k]);
        }
    }
}
