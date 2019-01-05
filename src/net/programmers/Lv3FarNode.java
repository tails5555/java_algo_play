package net.programmers;

import java.util.LinkedList;
import java.util.Queue;

// Programmers Lv3 가장 먼 노드 문제 풀Yee
public class Lv3FarNode {
    static final int MAX = 50001;
    public static int solution(int n, int[][] edge){
        boolean[][] map = new boolean[n+1][n+1];
        for(int k=0;k<edge.length;k++){
            int x = edge[k][0];
            int y = edge[k][1];
            map[x][y] = map[y][x] = true;
        }

        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for(int k=1;k<=n;k++){
            dist[k] = MAX;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        dist[1] = 0;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int k=1;k<=n;k++){
                if(!visited[k] && map[tmp][k]) {
                    dist[k] = Math.min(dist[tmp] + 1, dist[k]);
                    visited[k] = true;
                    queue.offer(k);
                }
            }
        }

        int res = 0;
        int mV = 0;
        for(int k=1;k<=n;k++){
            if(dist[k] > mV) {
                mV = dist[k];
                res = 1;
            } else if(dist[k] == mV) {
                res += 1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[][] graph = {
            { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 }
        };
        System.out.println(solution(6, graph));
    }
}
