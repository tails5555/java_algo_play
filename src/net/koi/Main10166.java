package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2014 중등부 관중석 문제 풀이
// Radius 는 오차가 존재하기 때문에, 기약 분수와 DP 를 이용하여 풀이하는 것을 요구한 문제.
public class Main10166 {
    static int gcd(int a, int b){
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[][] map = new boolean[2001][2001];
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int k = from; k <= to; k++){
            for(int l = 1; l <= k; l++){
                int m = gcd(l, k);
                if(!map[l / m][k / m]) { // 해당 기약분수가 저장이 안 되어 있으면 개수를 1씩 높인다.
                    map[l / m][k / m] = true;
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}