package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D2 스도쿠 검증 문제 풀이
public class Main1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            int[][] sudoku = new int[9][9];
            for(int l = 0; l < 9; l++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int idx = 0;
                while(st.hasMoreTokens()) {
                    sudoku[l][idx++] = Integer.parseInt(st.nextToken());
                }
            }

            boolean res = true;
            for(int l = 0; l < 9; l++){
                Set<Integer> set = new HashSet<>();

                for(int m = 0; m < 9; m++){
                    set.add(sudoku[l][m]);
                }
                if(set.size() != 9) {
                    res = false;
                    break;
                }
                set.clear();

                for(int m = 0; m < 9; m++){
                    set.add(sudoku[m][l]);
                }
                if(set.size() != 9) {
                    res = false;
                    break;
                }
                set.clear();

                int startRow = (l / 3) * 3;
                int startCol = (l % 3) * 3;
                for(int a = startRow; a < startRow + 3; a++){
                    for(int b = startCol; b < startCol + 3; b++){
                        set.add(sudoku[a][b]);
                    }
                }
                if(set.size() != 9) {
                    res = false;
                    break;
                }
            }

            System.out.printf("#%d %d\n", k+1, res ? 1 : 0);
        }
    }
}
