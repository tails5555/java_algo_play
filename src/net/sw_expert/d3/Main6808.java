package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// SW Expert D3 규영이와 인영이의 카드게임 문제 풀이
public class Main6808 {
    static int[] gy, iy;
    static boolean[] visited;
    static int gyWin;
    static int iyWin;

    static void backtracking(int gyPoint, int iyPoint, int idx){
        if(idx == 9) {
            if(gyPoint > iyPoint) {
                gyWin += 1;
            } else if(gyPoint < iyPoint) {
                iyWin += 1;
            }
        }
        for(int k = 0; k < 9; k++){
            if(!visited[k]) {
                visited[k] = true;
                backtracking(
                    gy[idx] > iy[k] ? gyPoint + (gy[idx] + iy[k]) : gyPoint,
                    gy[idx] < iy[k] ? iyPoint + (gy[idx] + iy[k]) : iyPoint,
                    idx + 1
                );
                visited[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            gy = new int[9];
            for(int l = 0; l < gy.length; l++){
                gy[l] = Integer.parseInt(st.nextToken());
            }

            iy = new int[9];
            Set<Integer> set = Arrays.stream(gy).boxed().collect(Collectors.toSet());
            int idx = 0;
            for(int l = 1; l <= 18; l++){
                if(!set.contains(l)){
                    iy[idx++] = l;
                }
            }

            visited = new boolean[9];
            gyWin = 0;
            iyWin = 0;
            backtracking(0, 0, 0);

            System.out.printf("#%d %d %d\n", k + 1, gyWin, iyWin);
        }
    }
}
