package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 진수의 홀수 약수 문제 풀이
// 풀이를 참고하였음. 이러한 솔루션이 있다는 사실을 깨달을 목적임.
public class Main5213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] memo = new long[1000001];
        for(int l = 1; l <= 1000000; l += 2){
            for(int m = 1; m <= 1000000 / l; m++){
                memo[l * m] += l;
            }
        }

        long[] subsum = new long[1000001];
        subsum[1] = memo[1];
        for(int k = 2; k <= 1000000; k++){
            subsum[k] = subsum[k - 1] + memo[k];
        }

        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.printf("#%d %d\n", k+1, subsum[end] - subsum[start - 1]);
        }
    }
}
