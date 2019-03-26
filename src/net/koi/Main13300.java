package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2016 초등부 방 배정 문제 풀이
public class Main13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] count = new int[6 + 1][2];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            count[grade][gender] += 1;
        }

        int room = 0;
        for(int k = 1; k <= 6; k++){
            for(int l = 0; l <= 1; l++){
                room += Math.ceil((double) count[k][l] / K);
            }
        }

        System.out.println(room);
    }
}
