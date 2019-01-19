package net.baekjoon.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 1477번 문제 휴게소 세우기 문제 풀이
// 풀이를 약간 참고하였음. 다시 풀어볼 필요 있음.
public class Main1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] area = new int[N + 2];

        int idx = 1;
        while(st.hasMoreTokens()){
            area[idx++] = Integer.parseInt(st.nextToken());
        }
        area[area.length - 1] = L;
        Arrays.sort(area);

        int start = 1;
        int end = L - 1;
        while(start <= end){
            int cnt = 0;
            int mid = start + Math.abs(end - start) /  2;

            for(int k=1;k<=N+1;k++){
                if(Math.abs(area[k] - area[k - 1]) > mid) {
                    cnt += (Math.abs(area[k] - area[k - 1]) - 1) / mid;
                }
            }

            if(cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
