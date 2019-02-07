package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 삼성 SW Expert D1 중앙 값 찾기 문제
public class Main2063 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> higher = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> lower = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            higher.offer(tmp);
            lower.offer(higher.poll());
            if(higher.size() < lower.size()) {
                higher.offer(lower.poll());
            }
        }

        System.out.println(higher.peek());
    }
}
