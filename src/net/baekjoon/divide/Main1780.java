package net.baekjoon.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1780 번 종Yee의 개수 문제 풀이
public class Main1780 {
    static int N;
    static int[][] paper;
    static int MINUS_VALUE = 0;
    static int ZERO_VALUE = 0;
    static int PLUS_VALUE = 0;

    public static boolean searching(int startX, int endX, int startY, int endY){
        int tmpValue = paper[startX][startY];
        boolean result = true;
        for(int k = startX;k <= endX; k++){
            for(int l = startY;l <= endY; l++){
                if(tmpValue != paper[k][l]) {
                    result = false;
                    break;
                }
            }
        }
        if(result){
            switch(tmpValue){
                case 1 :
                    PLUS_VALUE += 1;
                    break;
                case 0 :
                    ZERO_VALUE += 1;
                    break;
                case -1 :
                    MINUS_VALUE += 1;
                    break;
                default :
                    break;
            }
        }
        return result;
    }

    public static void solution(int size, int dx, int dy, int sx, int sy){
        int startX = dx * size + sx;
        int endX = dx * size + size - 1 + sx;
        int startY = dy * size + sy;
        int endY = dy * size + size - 1 + sy;

        if(searching(startX, endX, startY, endY)) return;

        int divideSize = size / 3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                solution(divideSize, k, l, startX, startY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        StringTokenizer st;
        for(int k=0;k<N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()){
                paper[k][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        solution(N, 0, 0, 0, 0);

        System.out.println(MINUS_VALUE);
        System.out.println(ZERO_VALUE);
        System.out.println(PLUS_VALUE);
    }
}
