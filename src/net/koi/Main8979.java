package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon KOI 2013 초등부 올림픽 문제 풀이
public class Main8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] olympiad = new int[N + 1][4];
        for(int k = 1; k <= N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            olympiad[k] = new int[] { nation, gold, silver, bronze };
        }

        if(N == 1) System.out.println(1);
        else {
            Arrays.sort(olympiad, 1, olympiad.length, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        if (o1[3] == o2[3]) {
                            return o1[0] - o2[0];
                        } else return o2[3] - o1[3];
                    } else return o2[2] - o1[2];
                } else return o2[1] - o1[1];
            });

            int rank = 0, ans = 0, same = 0;
            int[] result = new int[N + 1];
            for(int k = 1; k <= N; k++){
                if(olympiad[k - 1][1] == olympiad[k][1] && olympiad[k - 1][2] == olympiad[k][2] && olympiad[k - 1][3] == olympiad[k][3]) {
                    result[olympiad[k][0]] = result[olympiad[k - 1][0]];
                    same += 1;
                } else {
                    if(same == 0) {
                        rank += 1;
                    } else {
                        rank += (same + 1);
                        same = 0;
                    }

                    result[olympiad[k][0]] = rank;
                }
            }

            System.out.println(result[Q]);
        }
    }
}
