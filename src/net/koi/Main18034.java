package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2015 초등부 벨트 문제 풀이
// 비율을 계산할 때 long 을 이용해서 계산해야 함.
// A : B = a : b 일 때, A * b = B * a 가 성립됨을 알고 있어야 함.
public class Main18034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[] rotations = new long[N + 1];
        int[] directions = new int[N + 1];

        for(int k = 1; k <= N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            long left = Long.parseLong(st.nextToken());
            long right = Long.parseLong(st.nextToken());
            int direct = Integer.parseInt(st.nextToken());

            directions[k] = (direct == 1) ? (directions[k - 1] + 1) % 2 : directions[k - 1];

            if(k == 1) {
                rotations[0] = left;
                rotations[1] = right;
            } else {
                rotations[k] = right * rotations[k - 1] / left;
            }
        }

        System.out.println(directions[N] + " " + rotations[N]);
    }
}
