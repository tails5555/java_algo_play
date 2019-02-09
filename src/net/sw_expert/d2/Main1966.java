package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW Expert D2 숫자를 정렬하자 문제 풀이
public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[] tmp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                tmp[l] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp);
            StringBuilder sb = new StringBuilder();
            for(int t : tmp){
                sb.append(String.format("%d ", t));
            }
            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
