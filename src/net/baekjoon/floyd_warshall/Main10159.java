package net.baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10159 번 저울 풀이
public class Main10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int idx = 0;
        while(idx < M){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int high = Integer.parseInt(st.nextToken());
            int low = Integer.parseInt(st.nextToken());
            map[high][low] = 1;
            idx++;
        }

        for(int o=1;o<=N;o++)
            for(int l=1;l<=N;l++)
                for(int m=1;m<=N;m++)
                    if(map[l][o] == 1 && map[o][m] == 1)
                        map[l][m] = 1;

        for(int k=1;k<=N;k++){
            int cnt = -1;
            for(int l=1;l<=N;l++){
                if(map[k][l] == 0 && map[l][k] == 0)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
