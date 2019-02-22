package net.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 1051번 숫자 정사각형 문제 풀이
public class Main1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for(int k = 0; k < N; k++){
            map[k] = br.readLine().toCharArray();
        }

        int edge = Integer.MIN_VALUE;
        for(int k = 0; k < Math.min(N, M); k++){
            int rowCnt = N - k;
            int colCnt = M - k;

            Set<Character> set;
            for(int r = 0; r < rowCnt; r++){
                for(int c = 0; c < colCnt; c++){
                    int rowStart = r;
                    int rowEnd = r + k;
                    int colStart = c;
                    int colEnd = c + k;

                    set = new HashSet<>();
                    set.add(map[rowStart][colStart]);
                    set.add(map[rowStart][colEnd]);
                    set.add(map[rowEnd][colStart]);
                    set.add(map[rowEnd][colEnd]);

                    if(set.size() == 1)
                        edge = Math.max(edge, (k + 1) * (k + 1));
                }
            }
        }

        System.out.println(edge);
    }
}
