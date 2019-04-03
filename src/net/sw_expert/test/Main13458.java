package net.sw_expert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제(시험 감독) 문제 풀이
// long 과 ceil 를 잘 사용하면 발로 풀 수 있는 문제
public class Main13458 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] room = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int k = 0; k < N; k++){
            room[k] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        int header = Integer.parseInt(st.nextToken());
        int footer = Integer.parseInt(st.nextToken());

        long cnt = 0L;
        for(int k = 0; k < N; k++){
            room[k] -= header;
            cnt += 1L;
            if(room[k] > 0) {
                cnt += (long) Math.ceil((double) room[k] / footer);
            }
        }

        System.out.println(cnt);
    }
}
