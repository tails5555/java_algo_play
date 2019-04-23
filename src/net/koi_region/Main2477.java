package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2009 지역본선 초등부 3번 참외밭 문제 풀이
public class Main2477 {
    static BufferedReader br;
    static StringTokenizer st;

    static int w, width, height;
    static int[] dist;
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        width = 0;
        height = 0;

        w = Integer.parseInt(br.readLine());
        dist = new int[6];
        for(int k = 0; k < 6; k++){
            st = new StringTokenizer(br.readLine(), " ");

            Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            dist[k] = length;

            if(k % 2 == 0){
                width = Math.max(width, dist[k]);
            } else {
                height = Math.max(height, dist[k]);
            }
        }
    }

    static void solution() {
        int ww = 0, hh = 0;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (height == dist[(i + 5) % 6] + dist[(i + 1) % 6]) {
                    ww = dist[i];
                }
            } else {
                if (width == dist[(i + 5) % 6] + dist[(i + 1) % 6]) {
                    hh = dist[i];
                }
            }
        }

        System.out.println(((width * height) - (ww * hh)) * w);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
