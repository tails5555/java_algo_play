package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 장애물 경주 난이도 문제 풀이
public class Main6730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            int tmp = Integer.parseInt(st.nextToken());

            int upscale = Integer.MIN_VALUE;
            int downscale = Integer.MIN_VALUE;
            while(idx < N) {
                int next = Integer.parseInt(st.nextToken());
                if(next > tmp)
                    upscale = Math.max(upscale, next - tmp);
                else
                    downscale = Math.max(downscale, tmp - next);
                idx++;
                tmp = next;
            }

            upscale = upscale == Integer.MIN_VALUE ? 0 : upscale;
            downscale = downscale == Integer.MIN_VALUE ? 0 : downscale;
            System.out.printf("#%d %d %d\n", k+1, upscale, downscale);
        }
    }
}
