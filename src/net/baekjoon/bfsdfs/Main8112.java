package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Baekjoon 0 과 1 (2) 문제 풀이
// 8111 번 문제는 1000001 의 사이즈를 20001 로 바꿔 풀면 된다.
public class Main8112 {
    static class Pair {
        int num;
        char ele;

        public Pair(int num, char ele){
            this.num = num;
            this.ele = ele;
        }
    }

    static Pair[] pair;

    static void print(int num) {
        if (num == -1) return;
        print(pair[num].num);
        System.out.print(pair[num].ele);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Queue<Integer> queue;
        boolean[] visited;
        for(int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1) {
                System.out.println(N);
            } else {
                queue = new LinkedList<>();
                visited = new boolean[1000001];
                pair = new Pair[1000001];

                queue.offer(1);
                visited[1] = true;
                pair[1] = new Pair(-1, '1');

                while (!queue.isEmpty()) {
                    int tmp = queue.poll();

                    int[] num = {(tmp * 10) % N, (tmp * 10 + 1) % N};
                    for (int l = 0; l < 2; l++) {
                        if (!visited[num[l]]) {
                            pair[num[l]] = new Pair(tmp, (char) (l + '0'));
                            if (num[l] == 0) break;
                            visited[num[l]] = true;
                            queue.offer(num[l]);
                        }
                    }
                }

                print(0);
                System.out.println();
            }
        }
    }
}
