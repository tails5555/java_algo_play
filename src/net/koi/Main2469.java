package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baekjoon KOI 2010 초등부 사다리 타기 문제 풀이
// 위 Flow 와 아래 Flow 비교 과정을 거치고, 맞들어 비교하고 사다리를 그린다.
public class Main2469 {
    static final int QUESTION = -1;
    static final int EXISTED = 27;
    static final int NON_EXISTED = 28;

    static int left_right_flow(int[][] ladder, int idx, int size, int row, int left, int right) {
        int tmp = idx;
        if(left < 0) { // 왼쪽 길이 없는 경우
            tmp = tmp + ((ladder[row][right] == EXISTED) ? 1 : 0);
        } else if(right >= size - 1) { // 오른쪽 길이 없는 경우
            tmp = tmp + ((ladder[row][left] == EXISTED) ? -1 : 0);
        } else {
            if(ladder[row][left] == EXISTED) {
                tmp = tmp - 1;
            } else if(ladder[row][right] == EXISTED) {
                tmp = tmp + 1;
            }
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        char[] order = br.readLine().toCharArray();
        int[][] ladder = new int[N][K - 1];
        int pivot = -1;
        for(int k = 0; k < N; k++){
            char[] layer = br.readLine().toCharArray();
            for(int l = 0; l < layer.length; l++){
                if(layer[l] == '?') {
                    Arrays.fill(ladder[k], QUESTION);
                    pivot = k;
                    break;
                } else {
                    ladder[k][l] = (layer[l] == '*') ? NON_EXISTED : EXISTED;
                }
            }
        }

        int[] header = new int[K];
        for(int k = 0; k < K; k++){
            int idx = k;
            for(int l = 0; l < pivot; l++){
                int left = idx - 1;
                int right = idx;
                idx = left_right_flow(ladder, idx, K, l, left, right);
            }
            header[idx] = k;
        }

        int[] footer = new int[K];
        for(int k = 0; k < order.length; k++){
            int idx = k;
            for(int l = N - 1; l > pivot; l--){
                int left = idx - 1;
                int right = idx;
                idx = left_right_flow(ladder, idx, K, l, left, right);
            }
            footer[idx] = order[k] - 'A';
        }

        boolean checked = true;
        char[] ans = new char[K];
        for(int k = 0; k < ans.length; k++){
            if(header[k] == footer[k]) {
                ans[k] = '*';
            } else if(header[k + 1] == footer[k] && header[k] == footer[k + 1]) {
                ans[k] = '-';
                ans[k + 1] = '*';
                k += 1;
            } else {
                checked = false;
                break;
            }
        }

        if(checked){
            System.out.println(new String(Arrays.copyOfRange(ans, 0, K - 1)));
        } else {
            for(int k = 0; k < K - 1; k++){
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
