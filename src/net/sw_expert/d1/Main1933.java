package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 삼성 SW Expert D1 간단한 약수 문제
public class Main1933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[] { 1, N });

        while(!bfs.isEmpty()) {
            int[] tmp = bfs.poll();
            if(tmp[0] <= tmp[1]) {
                int mid = (tmp[0] + tmp[1]) / 2;
                if (N % mid == 0) {
                    queue.offer(mid);
                }
                bfs.offer(new int[]{tmp[0], mid - 1});
                bfs.offer(new int[]{mid + 1, tmp[1]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(String.format("%d ", tmp));
        }
        System.out.println(sb.toString());
    }
}
