package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 1966 프린터 큐 문제 풀이
// Queue 만 사용하는게 나은 문제. PQ 로 접근하면 문제에 따른 조건을 맞추기 힘듬.
// 최종 시간 복잡도는 O(n2) 로 나옴.
public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            Queue<int[]> queue = new LinkedList<>();
            for(int l = 0; l < N; l++){
                int t = Integer.parseInt(st.nextToken());
                queue.offer(new int[] { l, t });
            }

            int cnt = 0;
            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                boolean checked = true;
                for(int[] t : queue){
                    if(tmp[1] < t[1]) {
                        checked = false;
                        break;
                    }
                }
                if(checked) {
                    cnt += 1;
                    if(tmp[0] == M) break;
                } else {
                    queue.offer(tmp);
                }
            }

            System.out.println(cnt);
        }
    }
}
