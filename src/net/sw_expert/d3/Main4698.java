package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 테네스의 특별한 소수 문제 풀이
public class Main4698 {
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int k = 2; k <= 1000000; k++){
            for(int l = k * 2; l <= 1000000; l += k)
                isNotPrime[l] = true;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int l = start; l <= end; l++){
                if(!isNotPrime[l] && String.valueOf(l).contains(String.valueOf(N))) {
                    count += 1;
                }
            }
            System.out.printf("#%d %d\n", k+1, count);
        }
    }
}
