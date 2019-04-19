package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Baekjoon KOI 2005 중등부 1번 기댓값 문제 풀이
public class Main2592 {
    static BufferedReader br;
    static int avg;
    static Map<Integer, Integer> counter;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        avg = 0;
        counter = new HashMap<>();

        for(int k = 0; k < 10; k++){
            int t = Integer.parseInt(br.readLine());
            avg += (t / 10);

            int cnt = counter.getOrDefault(t, 0);
            counter.put(t, cnt + 1);
        }
    }

    static void solution() {
        System.out.println(avg);
        int n = 0;
        int max = 0;
        for(int t : counter.keySet()){
            int cnt = counter.get(t);
            if(max < cnt){
                max = cnt;
                n = t;
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
