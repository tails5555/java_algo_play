package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SW Expert D5 종구의 딸이름 짓기 문제 풀이
// 왜 런타임이 걸릴까?
public class Main7396 {
    static class Dist {
        String tmp;
        int n;
        int m;

        public Dist(String tmp, int n, int m) {
            this.tmp = tmp;
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            StringBuilder sb = new StringBuilder();

            for(int l = 0; l < N + M; l++){
                sb.append('z');
            }

            for(int n = 0; n < N; n++){
                map[n] = br.readLine().toCharArray();
            }

            String res = sb.toString();
            Queue<Dist> queue = new LinkedList<>();
            queue.offer(new Dist(new String(map[0][0] + ""), 0, 0));
            while(!queue.isEmpty()) {
                Dist dist = queue.poll();
                if(dist.tmp.compareTo(res) > 0) continue;
                if(dist.n == N - 1 && dist.m == M - 1) {
                    res = dist.tmp.compareTo(res) < 0 ? dist.tmp : res;
                }

                if(dist.n + 1 < N && dist.n >= 0)
                    queue.offer(new Dist(dist.tmp + map[dist.n + 1][dist.m], dist.n + 1, dist.m));
                if(dist.m + 1 < M && dist.m >= 0)
                    queue.offer(new Dist(dist.tmp + map[dist.n][dist.m + 1], dist.n, dist.m + 1));
            }

            System.out.printf("#%d %s\n", k + 1, res);
        }
    }
}
