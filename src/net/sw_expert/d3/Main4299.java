package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

// SW Expert D3 민국이의 사랑은 타이밍 풀이
public class Main4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LocalDateTime fefero = LocalDateTime.of(2011, 11, 11, 11, 11, 11);
            LocalDateTime time = LocalDateTime.of(2011, 11, D, H, M, 11);
            if(fefero.isBefore(time) || fefero.equals(time)) {
                System.out.printf("#%d %d\n", k+1, (int) Math.ceil(Duration.between(fefero, time).getSeconds() / 60.0));
            } else {
                System.out.printf("#%d -1\n", k+1);
            }
        }
    }
}
