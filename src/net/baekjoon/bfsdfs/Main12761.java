package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 12761번 돌다리 문제 풀이
// 전북대 프로그래밍 경진대회 문제
public class Main12761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.offer(new int[] { N, 0 }); // 마지막 인덱스의 값은 기를 모은 횟수.
        set.add(N);

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == M){
                count = Math.min(count, tmp[1]);
            }

            if(tmp[0] + 1 <= 100000) {
                if (!set.contains(tmp[0] + 1)) {
                    queue.offer(new int[]{ tmp[0] + 1, tmp[1] + 1 });
                    set.add(tmp[0] + 1);
                }
            }

            if(tmp[0] - 1 >= 0) {
                if (!set.contains(tmp[0] - 1)) {
                    queue.offer(new int[]{ tmp[0] - 1, tmp[1] + 1 });
                    set.add(tmp[0] - 1);
                }
            }

            if(tmp[0] + A <= 100000) {
                if (!set.contains(tmp[0] + A)) {
                    queue.offer(new int[]{ tmp[0] + A, tmp[1] + 1 });
                    set.add(tmp[0] + A);
                }
            }

            if(tmp[0] - A >= 0) {
                if (!set.contains(tmp[0] - A)) {
                    queue.offer(new int[]{ tmp[0] - A, tmp[1] + 1 });
                    set.add(tmp[0] - A);
                }
            }

            if(tmp[0] + B <= 100000) {
                if (!set.contains(tmp[0] + B)) {
                    queue.offer(new int[]{ tmp[0] + B, tmp[1] + 1 });
                    set.add(tmp[0] + B);
                }
            }

            if(tmp[0] - B >= 0) {
                if (!set.contains(tmp[0] - B)) {
                    queue.offer(new int[]{ tmp[0] - B, tmp[1] + 1 });
                    set.add(tmp[0] - B);
                }
            }

            if(tmp[0] * A <= 100000) {
                if(!set.contains(tmp[0] * A)){
                    queue.offer(new int[] { tmp[0] * A, tmp[1] + 1 });
                    set.add(tmp[0] * A);
                }
            }
            if(tmp[0] * B <= 100000) {
                if(!set.contains(tmp[0] * B)) {
                    queue.offer(new int[]{ tmp[0] * B, tmp[1] + 1 });
                    set.add(tmp[0] * B);
                }
            }
        }

        System.out.printf("%d\n", count);
    }
}
