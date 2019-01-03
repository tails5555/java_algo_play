package net.baekjoon.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2580 번 스도쿠 문제 풀Yee
public class Main2580 {
    static int[][] sudoku = new int[10][10];
    static int curX;
    static int curY;

    static boolean widthConfirm(int x, int value) {
        for(int k=1;k<=9;k++){
            if(sudoku[x][k] == value) return false;
        }
        return true;
    }

    static boolean heightConfirm(int y, int value) {
        for(int k=1;k<=9;k++){
            if(sudoku[k][y] == value) return false;
        }
        return true;
    }

    static boolean squareConfirm(int x, int y, int value) {
        int xStart = ((int)Math.ceil(x / 3.0) - 1) * 3 + 1;
        int yStart = ((int)Math.ceil(y / 3.0) - 1) * 3 + 1;
        for(int k=xStart;k<xStart+3;k++){
            for(int l=yStart;l<yStart+3;l++){
                if(sudoku[k][l] == value) return false;
            }
        }
        return true;
    }

    static boolean hasNotEmpty(){
        for(int k=1;k<=9;k++){
            for(int l=1;l<=9;l++){
                if(sudoku[k][l] == 0){
                    curX = k;
                    curY = l;
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean backtraking(){
        int x = curX;
        int y = curY;
        if(hasNotEmpty()) return true;
        x = curX;
        y = curY;
        for(int k=1;k<=9;k++){
            if(widthConfirm(x, k) && heightConfirm(y, k) && squareConfirm(x, y, k)) {
                sudoku[x][y] = k;
                if (backtraking()) return true;
                sudoku[x][y] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k=1;k<=9;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int l=1;l<=9;l++){
                sudoku[k][l] = Integer.parseInt(st.nextToken());
            }
        }

        backtraking();

        for(int k=1;k<=9;k++){
            for(int l=1;l<=9;l++){
                System.out.print(sudoku[k][l] + " ");
            }
            System.out.println();
        }
    }
}
