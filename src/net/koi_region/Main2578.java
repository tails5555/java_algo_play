package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Baekjoon KOI 2006 초등부 지역본선 3번 빙고 문제 풀이
public class Main2578 {
    static BufferedReader br;
    static StringTokenizer st;
    static Map<Integer, int[]> bingo;
    static int[] call;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new HashMap<>();
        for(int k = 0; k < 5; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < 5; l++){
                int tmp = Integer.parseInt(st.nextToken());
                bingo.put(tmp, new int[] { k, l });
            }
        }

        call = new int[25];
        for(int k = 0; k < 5; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < 5; l++){
                int tmp = Integer.parseInt(st.nextToken());
                call[k * 5 + l] = tmp;
            }
        }
    }

    static void solution() {
        int[] row = new int[5];
        int[] col = new int[5];
        int left_cross = 0;
        int right_cross = 0;

        for(int k = 0; k < 25; k++){
            int[] pos = bingo.get(call[k]);
            row[pos[0]] += 1;
            col[pos[1]] += 1;
            left_cross += (pos[0] == pos[1]) ? 1 : 0;
            right_cross += (pos[1] == 4 - pos[0]) ? 1 : 0;

            int line = (left_cross / 5) + (right_cross / 5);
            for(int l = 0; l < 5; l++){
                line += (row[l] / 5);
                line += (col[l] / 5);
            }
            if(line >= 3){
                System.out.println(k + 1);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
