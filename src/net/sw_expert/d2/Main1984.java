package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 중간 평균값 구하기 문제
public class Main1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[10];
            int idx = 0;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[idx++] = tmp;
                min = Math.min(min, tmp);
                max = Math.max(max, tmp);
            }

            int cnt = 0;
            int sum = 0;
            for(int l = 0; l < arr.length; l++){
                if(arr[l] != min && arr[l] != max) {
                    cnt += 1;
                    sum += arr[l];
                }
            }

            System.out.printf("#%d %d\n", k+1, (int) Math.round((double) sum / cnt));
        }
    }
}
