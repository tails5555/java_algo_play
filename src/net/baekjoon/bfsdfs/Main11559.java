package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Baekjoon 11559 번 뿌요뿌요 문제 풀이
// 연세대 프로그래밍 경진대회 문제
public class Main11559 {
    static BufferedReader br;

    static final int[] dr = { 1, 0, -1,  0 };
    static final int[] dc = { 0, 1,  0, -1 };

    static int res;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> list;

    static boolean hasInside(int r, int c) {
        return r >= 0 && r < 12 && c >= 0 && c < 6;
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for(int k = 0; k < 12; k++){
            map[k] = br.readLine().toCharArray();
        }
    }

    static void initialize() {
        visited = new boolean[12][6];
    }

    static void dfs(int r, int c, char color) {
        for(int k = 0; k < dr.length; k++){
            int tr = r + dr[k];
            int tc = c + dc[k];
            if(hasInside(tr, tc)) {
                if(!visited[tr][tc] && color == map[tr][tc]) {
                    list.add(new int[] { tr, tc });
                    visited[r][c] = true;
                    dfs(tr, tc, color);
                }
            }
        }
    }

    static void finding() {
        res = 0;
        while(true) {
            initialize();

            boolean flag = false;
            for (int r = 0; r < 12; r++) {
                for (int c = 0; c < 6; c++) {
                    if (map[r][c] != '.') {
                        list = new ArrayList<>();
                        list.add(new int[]{r, c});

                        visited[r][c] = true;
                        dfs(r, c, map[r][c]);

                        if (list.size() >= 4) {
                            flag = true;
                            for (int[] p : list) {
                                map[p[0]][p[1]] = '.';
                            }
                        }
                    }
                }
            }

            if(!flag) break;

            res += 1;
            rematch();
        }
    }

    static void rematch() {
        for(int c = 0; c < 6; c++){
            Queue<Character> queue = new LinkedList<>();
            for(int r = 0; r < 12; r++) {
                if(map[r][c] != '.') {
                    queue.offer(map[r][c]);
                }
                map[r][c] = '.';
            }

            int q_size = queue.size();
            for(int r = 12 - q_size; r < 12; r++){
                char tmp = queue.poll();
                map[r][c] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        finding();
        System.out.println(res);
    }
}
