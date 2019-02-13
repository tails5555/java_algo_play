package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 강변 빌딩 조망권 문제풀이
// 문제의 의도를 잘 파악하자!
public class Main1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k = 0; k < 10; k++) {
            int N = Integer.parseInt(br.readLine());
            int[] build = new int[N];
            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(idx < N) {
                build[idx++] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for(int l = 2; l < build.length - 2; l++){
                int left = Math.max(build[l - 1], build[l - 2]);
                int right = Math.max(build[l + 1], build[l + 2]);

                int tmp = build[l] - Math.max(left, right);
                if(tmp > 0)
                    sum += tmp;
            }
            System.out.printf("#%d %d\n", k+1, sum);
        }
    }
}
