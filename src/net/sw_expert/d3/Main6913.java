package net.sw_expert.d3;

import java.util.Arrays;
import java.util.Scanner;

// SW Expert D3 동철이의 프로그래밍 대회 문제 풀이
public class Main6913 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int k = 0; k < T; k++){
            int N = s.nextInt();
            int M = s.nextInt();

            int[] tmp = new int[N + 1];
            tmp[0] = Integer.MIN_VALUE;
            for(int l = 1; l <= N; l++)
                for(int m = 1; m <= M; m++)
                    tmp[l] += s.nextInt();

            Arrays.sort(tmp);
            int max = tmp[N];
            int cnt = 0;
            for(int l = N; l >= 1; l--){
                if(max == tmp[l]) cnt += 1;
                else break;
            }

            System.out.printf("#%d %d %d\n", k+1, cnt, max);
        }
    }
}
