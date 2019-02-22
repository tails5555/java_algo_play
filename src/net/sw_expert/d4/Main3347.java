package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 올림픽 종목 투표 문제 풀이
public class Main3347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            int[] b = new int[M];

            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                a[l] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < M; l++){
                b[l] = Integer.parseInt(st.nextToken());
            }

            int[] count = new int[N];
            for(int l = 0; l < M; l++){
                for(int m = 0; m < N; m++){
                    if(a[m] <= b[l]) {
                        count[m] += 1;
                        break;
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            int idx = -1;
            for(int l = 0; l < N; l++){
                if(max < count[l]) {
                    idx = l;
                    max = count[l];
                }
            }

            System.out.printf("#%d %d\n", k+1, idx + 1);
        }
    }
}
