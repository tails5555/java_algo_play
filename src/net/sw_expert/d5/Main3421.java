package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D5 수제 버거 장인 문제 풀이
// 비트 마스크를 공부하기 딱 좋은 문제였음.
public class Main3421 {
    public static void main(String[] args) throws IOException {
        int[] square = new int[22];
        square[1] = 1;
        for(int k = 2; k <= 21; k++){
            square[k] = 2 * square[k - 1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int cnt = square[N + 1];
            int[] combination = new int[M];
            for (int l = 0; l < M; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());

                combination[l] = square[s1] | square[s2];
            }

            int res = cnt;
            for (int i = 0; i < cnt; i++) {
                for (int j = 0; j < M; j++) {
                    int tmp = i & combination[j];
                    if (tmp == combination[j]) {
                        res--;
                        break;
                    }
                }
            }

            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
