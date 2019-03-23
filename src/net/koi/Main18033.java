package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2015 초등부 사과 문제 풀이
public class Main18033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        StringTokenizer st;
        for(int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int people = Integer.parseInt(st.nextToken());
            int apples = Integer.parseInt(st.nextToken());
            cnt += (apples % people);
        }

        System.out.println(cnt);
    }
}
