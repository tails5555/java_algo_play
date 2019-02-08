package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 아름Yee의 돌 던지기 문제
// 자바 제출을 막았음. 이건 번외 문제로 남기겠음.
public class Main1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int l=0;l<N;l++){
                int tmp = Integer.parseInt(st.nextToken());
                if(min > Math.abs(tmp)) {
                    min = Math.abs(tmp);
                    cnt = 0;
                }
                if(min == Math.abs(tmp)) cnt++;
            }
            System.out.printf("#%d %d %d\n", k+1, min, cnt);
        }
    }
}
