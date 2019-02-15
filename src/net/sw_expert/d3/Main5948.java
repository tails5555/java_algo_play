package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// SW Expert D3 욱진이의 7-3-5 게임 문제 풀이
// 백트래킹이 약간 필요한 문제
public class Main5948 {
    static boolean[] visited;
    static int[] arr;
    static List<Integer> list;

    static void backtracking(int cnt, int sum) {
        if(cnt == 3) {
            list.add(sum);
        } else {
            for(int k = 0; k < 7; k++){
                if(!visited[k]) {
                    visited[k] = true;
                    backtracking(cnt + 1, sum + arr[k]);
                    visited[k] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            visited = new boolean[7];
            arr = new int[7];
            list = new ArrayList<>();

            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            backtracking(0, 0);
            list = list.stream().distinct().sorted().collect(Collectors.toList());
            System.out.printf("#%d %d\n", k+1, list.get(list.size() - 5));
        }
    }
}
