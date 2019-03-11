package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D4 격자판의 숫자 이어 붙이기 문제 풀이
public class Main2819 {
    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    static Set<String> set;
    static String[][] map;
    static void backtracking(int x, int y, int count, String code){
        if(count == 6) {
            set.add(code);
            return;
        }

        for(int k = 0; k < dx.length; k++){
            int tx = x + dx[k];
            int ty = y + dy[k];
            if(tx >= 0 && tx <= 3 && ty >= 0 && ty <= 3){
                backtracking(tx, ty, count + 1, code + map[tx][ty]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            map = new String[4][4];
            for(int l = 0; l < 4; l++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int m = 0; m < 4; m++){
                    map[l][m] = st.nextToken();
                }
            }

            set = new HashSet<>();
            for(int l = 0; l < 4; l++){
                for(int m = 0; m < 4; m++){
                    backtracking(l, m, 0, map[l][m]);
                }
            }

            System.out.printf("#%d %d\n", k + 1, set.size());
        }
    }
}
