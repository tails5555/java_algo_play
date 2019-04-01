package net.sw_expert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제(잉융치킹 배달) 문제 풀이
// 엄마는 치킨을 안 좋아하세요 회를 좋아하시지
public class Main15686 {
    static BufferedReader br;
    static StringTokenizer st;
    static final int MAX = 87654321;
    static int N, M, ans;

    static boolean[] visited;
    static List<int[]> home;
    static List<int[]> chicken;

    static void backtracking(int idx, int cnt){
        if(idx > chicken.size()) return;

        if(cnt == M) {
            int count = 0;
            for(int k = 0; k < home.size(); k++){
                int dist = MAX;
                for(int l = 0; l < chicken.size(); l++){
                    if(visited[l]){
                        int[] h = home.get(k);
                        int[] c = chicken.get(l);
                        int tmp = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                        dist = Math.min(dist, tmp);
                    }
                }
                count += dist;
            }

            ans = Math.min(ans, count);
            return;
        }

        visited[idx] = true;
        backtracking(idx + 1, cnt + 1);

        visited[idx] = false;
        backtracking(idx + 1, cnt);
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int k = 1; k <= N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 1; l <= N; l++){
                int tmp = Integer.parseInt(st.nextToken());
                switch(tmp){
                    case 1:
                        home.add(new int[] { k, l });
                        break;
                    case 2:
                        chicken.add(new int[] { k, l });
                        break;
                }
            }
        }
    }

    static void initialize() {
        visited = new boolean[chicken.size() + 1];
        ans = MAX;
    }

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        backtracking(0, 0);
        System.out.println(ans);
    }
}
