package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baekjoon 5545 번 최고의 피자 문제 풀이
public class Main5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int k = 0; k < N; k++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int fee = A;
        int calorie = C;
        int ans = C / A;
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            calorie += tmp;
            fee += B;
            ans = Math.max(ans, calorie / fee);
        }

        System.out.println(ans);
    }
}
