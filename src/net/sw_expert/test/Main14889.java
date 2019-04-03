package net.sw_expert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제(스타트와 링크) 문제 풀이
public class Main14889 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int res;

    // 1단계. 입력
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                map[k][l] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 2단계. 백트래킹을 위한 변수 초기화 과정
    static void initialize() {
        visited = new boolean[N];
        res = Integer.MAX_VALUE;
    }

    // 3단계. 백트래킹 진행.
    // 여기서는 선택한 기록이 남아 있어야 팀을 나눔.
    static void backtracking(int idx, int cnt) {
        if(cnt == N / 2) {
            divide_team();
        }
        for(int k = idx; k < N; k++){
            if(!visited[k]) {
                visited[k] = true;
                backtracking(k, cnt + 1);
                visited[k] = false;
            }
        }
    }

    // 4-1 단계. 백트래킹의 할당량을 거친 후의 팀 분할
    // visited 가 true 이면 청팀, false 이면 백팀으로 보냄.
    static void divide_team() {
        int[] blue_team = new int[(N / 2) + 1];
        int[] white_team = new int[(N / 2) + 1];

        int b_idx = 1;
        int w_idx = 1;
        for(int k = 0; k < N; k++){
            if(visited[k]) blue_team[b_idx++] = k;
            else white_team[w_idx++] = k;
        }

        int blue_power = team_power(blue_team);
        int white_power = team_power(white_team);

        // 팀 파워 점수 차이 값의 최소화 값을 유추함.
        res = Math.min(res, Math.abs(blue_power - white_power));
    }

    // 4-2 단계. 팀 스킬 점수 획득
    // 팀 스킬 점수를 얻기 위하여 모든 간선을 연결해야 함.
    // 이는 어쩔 수 없이 브루트 포스를 사용해야 함. 시간 복잡도는 O(N^2) 로 나옴.
    static int team_power(int[] member) {
        int score = 0;
        for(int k = 1; k < member.length; k++){
            for(int l = k + 1; l < member.length; l++){
                score += (map[member[k]][member[l]] + map[member[l]][member[k]]);
            }
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        backtracking(0, 0);
        System.out.println(res);
    }
}
