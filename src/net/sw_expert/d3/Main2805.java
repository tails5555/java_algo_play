package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 농작물 수확하기 문제 풀이
public class Main2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int mid = (N - 1) / 2;
            int sum = 0;
            for(int l = 0; l < N; l++){
                int idx = 0;
                int pivot = l < mid ? l : N - 1 - l;
                int start = mid - pivot;
                int end = mid + pivot;
                int tmp;
                for(char c : br.readLine().toCharArray()) {
                    tmp = c - '0';
                    if(idx >= start && idx <= end)
                        sum += tmp;
                    idx += 1;
                }
            }
            System.out.printf("#%d %d\n", k + 1, sum);
        }
    }
}
