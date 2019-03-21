package net.sw_expert.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D6 화학물질2 문제 풀이
public class Main1260 {
    static int N;
    static int res;
    static final int[] dr = { 1, 0 };
    static final int[] dc = { 0, 1 };
    static List<int[]> matrix;
    static Set<Integer> visited;

    static boolean hasInside(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static int multiply_min(List<int[]> matrix) {
        int[][] dp = new int[matrix.size()][matrix.size()];
        for(int dist = 1; dist < matrix.size(); dist++) {
            for(int start = 0; start < matrix.size() - dist; start++){
                int end = start + dist;
                dp[start][end] = Integer.MAX_VALUE;
                for(int mid = start; mid < end; mid++){
                    int cnt = dp[start][mid];
                    cnt += dp[mid + 1][end];
                    cnt += (matrix.get(start)[0] * matrix.get(mid)[1] * matrix.get(end)[1]);
                    dp[start][end] = Math.min(dp[start][end], cnt);
                }
            }
        }
        return dp[0][matrix.size() - 1];
    }

    static void dfs(int idx, int cnt, List<int[]> mat){
        if(cnt == matrix.size()){
            res = Math.min(res, multiply_min(mat));
            return;
        }
        visited.add(idx);
        for(int k = 0; k < matrix.size(); k++){
            if(matrix.get(idx)[1] == matrix.get(k)[0] && !visited.contains(k)) {
                mat.set(cnt, matrix.get(k));
                dfs(k, cnt + 1, mat);
                mat.set(cnt, null);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            N = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[N][N];
            for(int l = 0; l < N; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int m = 0; m < N; m++){
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp > 0) map[l][m] = true;
                }
            }

            matrix = new LinkedList<>();
            res = Integer.MAX_VALUE;
            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    if(map[l][m]) {
                        map[l][m] = false;
                        int tl = Integer.MIN_VALUE;
                        int tm = Integer.MIN_VALUE;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[] { l, m });
                        while(!queue.isEmpty()) {
                            int[] tmp = queue.poll();
                            tl = Math.max(tl, tmp[0]);
                            tm = Math.max(tm, tmp[1]);
                            for(int t = 0; t < dr.length; t++){
                                int tr = dr[t] + tmp[0];
                                int tc = dc[t] + tmp[1];
                                if(hasInside(tr, tc)) {
                                    if(map[tr][tc]) {
                                        queue.offer(new int[]{tr, tc});
                                        map[tr][tc] = false;
                                    }
                                }
                            }
                        }
                        matrix.add(new int[] { Math.abs(tl - l) + 1, Math.abs(tm - m) + 1 });
                    }
                }
            }

            for(int l = 0; l < matrix.size(); l++){
                visited = new HashSet<>();
                List<int[]> mat = new ArrayList<>();
                for(int m = 0; m < matrix.size(); m++){
                    mat.add(new int[] { 0, 0 });
                }
                mat.set(0, matrix.get(l));
                dfs(l, 1, mat);
            }
            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
