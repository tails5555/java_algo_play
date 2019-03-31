package net.sw_expert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제(나무 재텤)
// BFS 문제는 아니고 시뮬레이션 문제와 가까움.
public class Main16235 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, K;
    static final int[] dr = { -1, -1, -1, 0, 1, 1,  1,  0 };
    static final int[] dc = { -1,  0,  1, 1, 1, 0, -1, -1 };

    static int[][] land, ins; // land 는 양분, ins 는 겨울 철에 필요한 추가 양분이다.
    static Map<Pos, List<Integer>> trees;

    static class Pos {
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Pos == false) return false;
            Pos p = (Pos) obj;
            return p.r == this.r && p.c == this.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.r, this.c);
        }

        @Override
        public String toString() {
            return String.format("(%d %d)", this.r, this.c);
        }
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        land = new int[N + 1][N + 1];
        ins = new int[N + 1][N + 1];

        for(int k = 1; k <= N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 1; l <= N; l++){
                land[k][l] = 5;
                ins[k][l] = Integer.parseInt(st.nextToken());
            }
        }

        trees = new HashMap<>();
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            List<Integer> list = trees.getOrDefault(new Pos(r, c), new ArrayList<>());
            list.add(age);
            trees.put(new Pos(r, c), list);
        }
    }

    static boolean has_inside(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }

    static void spring_summer() {
        for(int k = 1; k <= N; k++){
            for(int l = 1; l <= N; l++){
                if(trees.containsKey(new Pos(k, l))) {
                    List<Integer> list = trees.get(new Pos(k, l));
                    List<Integer> tmp = new ArrayList<>();
                    int die_land = 0;

                    Collections.sort(list);
                    for(int tree : list){
                        if(land[k][l] >= tree) {
                            land[k][l] -= tree;
                            tmp.add(tree + 1);
                        } else {
                            die_land += (tree / 2);
                        }
                    }

                    trees.put(new Pos(k, l), tmp);
                    land[k][l] += die_land;
                }
            }
        }
    }

    static void autumn() {
        for(int k = 1; k <= N; k++){
            for(int l = 1; l <= N; l++){
                if(trees.containsKey(new Pos(k, l))) {
                    List<Integer> list = trees.get(new Pos(k, l));
                    for(int tree : list) {
                        if(tree % 5 == 0)
                            for (int m = 0; m < 8; m++) {
                                int tr = k + dr[m];
                                int tc = l + dc[m];
                                if(has_inside(tr, tc)) {
                                    List<Integer> tmp = trees.getOrDefault(new Pos(tr, tc), new ArrayList<>());
                                    tmp.add(1);
                                    trees.put(new Pos(tr, tc), tmp);
                                }
                            }
                    }
                }
            }
        }
    }

    static void winter() {
        for(int k = 1; k <= N; k++){
            for(int l = 1; l <= N; l++){
                land[k][l] += ins[k][l];
            }
        }
    }

    static void solution() {
        for(int k = 0; k < K; k++){
            spring_summer();
            autumn();
            winter();
        }
    }

    static void answer() {
        int ans = 0;
        for(Pos pos : trees.keySet()){
            ans += trees.get(pos).size();
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        answer();
    }
}
