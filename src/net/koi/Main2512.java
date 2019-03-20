package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon KOI 2012 초등부 예산 문제 풀이
public class Main2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] region = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int k = 0; k < N; k++){
            region[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(region);
        int budget = Integer.parseInt(br.readLine());

        int start = 0;
        int end = budget;

        int maxSum = 0;
        int maxUpper = 0;
        while(start < end){
            int mid = (start + end) / 2;
            int tmp = Arrays.stream(region).map(a -> Math.min(a, mid)).sum();
            if(tmp <= budget) {
                if(maxSum < tmp) {
                    maxSum = tmp;
                    maxUpper = mid;
                }
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(Math.min(maxUpper, region[N - 1]));
    }
}
