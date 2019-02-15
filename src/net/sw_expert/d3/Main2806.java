package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 N Queen 문제 풀이
// Backtracking 의 기초적인 문제로 꼭 알아둬야 하는 문제로 뽑힘.
public class Main2806 {
    static int count;

    // 같은 열에 둘 일이 그렇게 없기 때문에 같은 행과 대각선들의 로직만 걸러내면 된다.
    static boolean hasChecked(int[] col, int idx) {
        for(int k = 0; k < idx; k++){
            // 같은 행을 알아보는 건 상당히 쉽다.
            if(col[k] == col[idx]) return false;
            // 그렇지만 현재 점에서 대각선을 알아 보는 것은 열의 너비와 행의 차이가 같음으로 인지할 수 있다.
            if(col[k] - col[idx] == idx - k) return false;
            if(col[idx] - col[k] == idx - k) return false;
        }
        return true;
    }

    static void nQueen(int[] col, int cnt) {
        if(cnt >= col.length) {
            count += 1;
        } else {
            for(int k = 0; k < col.length; k++){
                col[cnt] = k;
                if(hasChecked(col, cnt))
                    nQueen(col, cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int limit = Integer.parseInt(br.readLine());
            count = 0;
            nQueen(new int[limit], 0);
            System.out.printf("#%d %d\n", k+1, count);
        }
    }
}
