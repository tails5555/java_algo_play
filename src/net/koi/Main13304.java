package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2016 중등부 방 배정 문제 풀이
public class Main13304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int primary = 0;
        int[][] count = new int[2][2];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if(grade == 1 || grade == 2) primary += 1;
            else {
                count[(grade - 3) / 2][gender] += 1;
            }
        }

        int room = (int) Math.ceil((double) primary / K);
        for(int k = 0; k <= 1; k++){
            for(int l = 0; l <= 1; l++){
                room += Math.ceil((double) count[k][l] / K);
            }
        }

        System.out.println(room);
    }
}
