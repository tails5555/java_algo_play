package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Baekjoon KOI 2008 초등부 지역본선 1번 약수 구하기 문제 풀이
public class Main2501 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static Set<Integer> set;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
    }

    static void solution() {
        set = new TreeSet<>();
        for(int k = 1; k * k <= N; k++){
            if(N % k == 0) {
                set.add(k);
                set.add(N / k);
            }
        }

        int[] map = set.stream().mapToInt(i -> i).toArray();
        if(K >= 0 && K < map.length){
            System.out.println(map[K]);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
