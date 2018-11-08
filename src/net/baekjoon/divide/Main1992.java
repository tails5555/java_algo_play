package net.baekjoon.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1992번 쿼드 트리 문제 풀이
public class Main1992 {
    static int N;
    static int[][] picture;
    static StringBuilder str;

    public static int searching(int startX, int endX, int startY, int endY) {
        int tmpValue = picture[startX][startY];
        boolean result = true;
        for (int k = startX; k <= endX; k++) {
            for (int l = startY; l <= endY; l++) {
                if (tmpValue != picture[k][l]) {
                    result = false;
                    break;
                }
            }
        }
        if (result) return tmpValue;
        else return -1;
    }

    public static void solution(int size, int dx, int dy, int sx, int sy){
        int startX = dx * size + sx;
        int endX = dx * size + size - 1 + sx;
        int startY = dy * size + sy;
        int endY = dy * size + size - 1 + sy;

        int funcResult = searching(startX, endX, startY, endY);
        if(funcResult != -1) {
            str.append(funcResult);
            return;
        }

        str.append("(");
        int divideSize = size / 2;
        for(int k=0;k<2;k++){
            for(int l=0;l<2;l++){
                solution(divideSize, k, l, startX, startY);
            }
        }
        str.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new int[N][N];

        for(int k=0;k<N;k++){
            String str = br.readLine();
            char[] nums = str.toCharArray();
            for(int l=0;l<nums.length;l++){
                picture[k][l] = nums[l] - '0';
            }
        }

        str = new StringBuilder();
        solution(N, 0, 0, 0, 0);
        System.out.println(str.toString());
    }
}
