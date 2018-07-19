package net.sds_academy.type_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T+1];
        int N, M, r1, r2, c1, c2;
        for(int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            int height = Math.min(Math.abs(r1 - r2), N - Math.abs(r1 - r2));
            int width = Math.min(Math.abs(c1 - c2), M - Math.abs(c1 - c2));

            result[k] = height + width;
        }
        for(int k=1;k<=T;k++){
            System.out.printf("#%d %d\n", k, result[k]);
        }
    }
}
