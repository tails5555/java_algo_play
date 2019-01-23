package net.hackerrank.array;

// Hacker Rank Array 문제
// 1번. 2D Array - DS 문제 (모래 시계 범위에 따른 최대 합 구하기)
public class Example01 {
    // 범위를 아예 N 을 6(정사각배열)으로 설정하였음.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int k = 1; k <= 4; k++){
            for(int l = 1; l <= 4; l++){
                int tmp = 0;
                int startR = k - 1;
                int endR = k + 1;
                int startC = l - 1;
                int endC = l + 1;
                for(int m = startR; m <= endR; m++) {
                    if (m != (startR + endR) / 2) {
                        for (int n = startC; n <= endC; n++) {
                            tmp += arr[m][n];
                        }
                    } else {
                        tmp += arr[(startR + endR) / 2][(startC + endC) / 2];
                    }
                }
                max = Math.max(max, tmp);
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(hourglassSum(new int[][] {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        }));
        System.out.println(hourglassSum(new int[][] {
            { -9, -9, -9, 1, 1, 1 },
            { 0, -9,  0, 4, 3, 2 },
            { -9, -9, -9, 1, 2, 3 },
            { 0, 0, 8, 6, 6, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        }));
    }
}
