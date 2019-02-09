package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 두 개의 숫자열 문제 풀이
public class Main1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[Math.max(N, M)][2];
            int nIdx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                arr[nIdx++][Math.max(N, M) == N ? 0 : 1] = Integer.parseInt(st.nextToken());
            }
            int mIdx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                arr[mIdx++][Math.max(N, M) == M ? 0 : 1] = Integer.parseInt(st.nextToken());
            }

            int res = Integer.MIN_VALUE;
            int pivot = Math.min(N, M);
            for(int l = 0; l <= Math.abs(N - M); l++) {
                int tmp = 0;
                for(int m = l; m < l + pivot; m++){
                    tmp += (arr[m][0] * arr[m - l][1]);
                }
                res = Math.max(res, tmp);
            }

            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
