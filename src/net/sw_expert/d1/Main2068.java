package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 삼성 SW Expert D1 최댓값 찾기 문제
public class Main2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Integer> higher = new PriorityQueue<>(Comparator.reverseOrder());
            while(st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                higher.offer(tmp);
            }
            System.out.println("#" + (k + 1) + " " + higher.poll());
        }
    }
}
