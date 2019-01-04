package net.programmers;

import java.util.LinkedList;
import java.util.Queue;

// Programmers Lv3 네트워크 문제 풀Yee
public class Lv3Network {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for(int k=0;k<n;k++) {
            if(!visited[k]) {
                queue.offer(k);
                visited[k] = true;
                while (!queue.isEmpty()) {
                    int tmp = queue.poll();
                    for (int l=0;l<n;l++) {
                        if (!visited[l] && computers[tmp][l] == 1) {
                            visited[l] = true;
                            queue.offer(l);
                        }
                    }
                }
                answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] computer1 = {
            { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 }
        };
        int[][] computer2 = {
            { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 }
        };
        System.out.println(solution(3, computer1));
        System.out.println(solution(3, computer2));
    }
}
