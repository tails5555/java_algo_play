package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW Expert D4 한솔이의 택배 알바 문제 풀이
// 일단 제출이 안 되어 보류
public class Main7333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            int[] weight = new int[N];
            for(int l = 0; l < N; l++){
                weight[l] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(weight);

            int left = 0;
            int right = weight.length - 1;
            int cnt = 0;
            while(true) {
                if(left < right) {
                    if (weight[right] >= 50) {
                        cnt += 1;
                        right -= 1;
                    } else {
                        if (weight[right] * Math.abs(right - left + 1) >= 50) {
                            cnt += 1;
                        }
                        left += 1;
                        right -= 1;
                    }
                } else break;
            }

            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}