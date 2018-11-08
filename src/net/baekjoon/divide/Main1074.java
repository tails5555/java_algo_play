package net.baekjoon.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1074번 Z 문제 풀이
public class Main1074 {
    static int N;
    static int cnt;
    static int R;
    static int C;
    static int result = -1;
    public static void drawing(int size, int dx, int dy, int sx, int sy){
        int startX = dx * size + sx;
        int endX = dx * size + size - 1 + sx;
        int startY = dy * size + sy;
        int endY = dy * size + size - 1 + sy;

        if(Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1){
            for(int k=startX;k<=endX;k++){
                for(int l=startY;l<=endY;l++){
                    ++cnt;
                    if(R == k && C == l) {
                        result = cnt;
                        break;
                    }
                }
            }
        } else {
            int divideSize = size / 2;
            for(int k=0;k<2;k++){
                for(int l=0;l<2;l++){
                    drawing(divideSize, k, l, startX, startY);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cnt = -1;
        drawing((int)Math.pow(2, N), 0, 0, 0, 0);
        System.out.println(result);
    }
}
