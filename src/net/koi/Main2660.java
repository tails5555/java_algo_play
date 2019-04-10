package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 2660 번 KOI 1999 초딩부 회장뽑기 문제 풀이
public class Main2660 {
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for(int k = 1; k <= N; k++){
            Arrays.fill(map[k], MAX);
            map[k][k] = 0;
        }

        while(true){
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(from == -1 && to == -1) break;

            map[from][to] = map[to][from] = 1;
        }

        for(int m = 1; m <= N; m++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(m == a || m == b || a == b) continue;
                    if(map[a][b] > map[a][m] + map[m][b]) {
                        map[a][b] = map[a][m] + map[m][b];
                    }
                }
            }
        }

        int len = 0, minR = MAX;
        int[] cnts = new int[N + 1];
        for(int k = 1; k <= N; k++){
            int max = 0;
            for(int l = 1; l <= N; l++)
                if(max < map[k][l]) max = map[k][l];

            if(max <= minR){
                if(max != minR) len=0;
                cnts[len++] = k;
                minR = max;
            }
        }

        System.out.printf("%d %d\n", minR, len);
        for(int k = 0; k < len; k++) {
            System.out.print(cnts[k] + " ");
        }
    }
}
