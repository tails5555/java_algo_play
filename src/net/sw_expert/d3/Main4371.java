package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// SW Expert D3 항구에 들어오는 배 문제 풀이
// 에라토스테네스의 체 응용에 딱 맞아드는 문제
public class Main4371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[] boat = new int[N];
            for(int l = 0; l < N; l++){
                boat[l] = Integer.parseInt(br.readLine());
            }
            for(int l = 1; l < N; l++){
                if(boat[l] < 0) continue;
                int day1 = boat[l] - 1;
                for(int m = l + 1; m < N; m++){
                    if(boat[m] < 0) continue;
                    int day2 = boat[m] - 1;
                    if(day2 % day1 == 0)
                        boat[m] = -1;
                }
            }

            int cnt = (int) Arrays.stream(boat).filter(m -> m > 0).count();
            System.out.printf("#%d %d\n", k+1, cnt - 1);
        }
    }
}
