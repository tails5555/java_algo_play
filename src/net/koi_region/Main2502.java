package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2008 초등부 지역본선 2번 떡 먹는 스윙스 문제 풀이
public class Main2502 {
    static BufferedReader br;
    static StringTokenizer st;

    static int[] fibo;
    static int D, K;
    static void fibo_init() {
        fibo = new int[30 + 1];
        fibo[1] = fibo[2] = 1;
        for(int k = 3; k <= 30; k++){
            fibo[k] = fibo[k - 1] + fibo[k - 2];
        }
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        if(D == 1 || D == 2){
            System.out.println(K);
        } else {
            for(int a = 1; a <= K / 2; a++){
                for(int b = 1; b <= K; b++){
                    int rice_cake = fibo[D - 2] * a + fibo[D - 1] * b;
                    if(rice_cake > K) break;
                    else if(rice_cake == K){
                        System.out.println(a);
                        System.out.println(b);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        fibo_init();
        input();
        solution();
    }
}
