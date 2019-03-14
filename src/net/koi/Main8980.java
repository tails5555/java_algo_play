package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon KOI 2013 초등부 택배 문제 풀이
// 어려워서 풀이 참조하였음...ㅜㅜ
public class Main8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[][] dist = new int[M][3];
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            dist[k] = new int[] { from, to, capacity };
        }

        Arrays.sort(dist, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else return o1[1] - o2[1];
        });

        for(int[] k : dist){
            System.out.println(Arrays.toString(k));
        }
        int res = 0;
        int[] capacity = new int[N + 1];
        for(int k = 0; k < M; k++){
            int boxes = 0;
            for(int l = dist[k][0]; l < dist[k][1]; l++){
                boxes = Math.max(boxes, capacity[l]);
            }
            int remain = Math.min(dist[k][2], C - boxes);
            res += remain;
            for(int l = dist[k][0]; l < dist[k][1]; l++){
                capacity[l] += remain;
            }
        }
        System.out.println(res);
    }
}
