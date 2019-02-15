package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 인석이의 세로로 말해요 문제 풀이
public class Main5356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            char[][] arr = new char[5][15];
            int range = 0;
            for(int l = 0; l < 5; l++){
                char[] tmp = br.readLine().toCharArray();
                range = Math.max(range, tmp.length);
                System.arraycopy(tmp, 0, arr[l], 0, tmp.length);
            }

            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < range; l++){
                for(int m = 0; m < 5; m++){
                    if(arr[m][l] != 0)
                        sb.append(arr[m][l]);
                }
            }

            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
