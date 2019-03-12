package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1963번 소수 경로 문제 풀이
public class Main1963 {
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[10001];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int k = 2; k <= 10000; k++){
            if(!isNotPrime[k]) {
                for (int l = k * k; l <= 10000; l += k) {
                    isNotPrime[l] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            String from = st.nextToken();
            String to = st.nextToken();

            if(from.equals(to)){
                System.out.println(0);
            } else {
                int cnt = Integer.MAX_VALUE;

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{ Integer.parseInt(from), 0 });

                boolean[] visited = new boolean[10001];
                visited[Integer.parseInt(from)] = true;

                while (!queue.isEmpty()) {
                    int[] tmp = queue.poll();
                    if(tmp[0] == Integer.parseInt(to)){
                        cnt = Math.min(cnt, tmp[1]);
                    }
                    char[] num = String.valueOf(tmp[0]).toCharArray();
                    for(int l = 0; l < 4; l++){
                        for(int m = 0; m < 10; m++){
                            char temp = num[l];
                            num[l] = (char)('0' + m);
                            int target = Integer.parseInt(new String(num));
                            if(!isNotPrime[target] && !visited[target] && target > 1000) {
                                visited[target] = true;
                                queue.offer(new int[]{ target, tmp[1] + 1 });
                            }
                            num[l] = temp;
                        }
                    }
                }

                System.out.println(cnt);
            }
        }
    }
}
