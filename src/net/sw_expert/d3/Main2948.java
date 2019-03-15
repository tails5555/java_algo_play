package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D3 문자열 교집합 문제 풀이
public class Main2948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim(), " ");
            Set<String> set1 = new HashSet<>();
            for(int l = 0; l < N; l++){
                set1.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine().trim(), " ");
            Set<String> set2 = new HashSet<>();
            for(int l = 0; l < M; l++){
                set2.add(st.nextToken());
            }

            set1.retainAll(set2);

            System.out.printf("#%d %d\n", k + 1, set1.size());
        }
    }
}
