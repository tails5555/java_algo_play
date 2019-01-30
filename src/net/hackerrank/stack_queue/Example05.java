package net.hackerrank.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

// Hacker Rank Stack, Queue 응용 문제
// Castle On Grid 문제
public class Example05 {
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        char[][] map = new char[grid.length][grid.length];
        boolean[][] visited = new boolean[grid.length][grid.length];

        for(int k = 0; k < grid.length; k++) {
            map[k] = grid[k].toCharArray();
        }

        int cnt = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startX, startY, 0 });
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if(tmp[0] == goalX && tmp[1] == goalY) {
                cnt = Math.min(cnt, tmp[2]);
            }

            for(int x1 = tmp[0] + 1; x1 <= map.length - 1 && map[x1][tmp[1]] != 'X'; x1++){
                if(!visited[x1][tmp[1]]) {
                    queue.offer(new int[] { x1, tmp[1], tmp[2] + 1 });
                    visited[x1][tmp[1]] = true;
                }
            }

            for(int x2 = tmp[0] - 1; x2 >= 0 && map[x2][tmp[1]] != 'X'; x2--) {
                if(!visited[x2][tmp[1]]) {
                    queue.offer(new int[] { x2, tmp[1], tmp[2] + 1 });
                    visited[x2][tmp[1]] = true;
                }
            }

            for(int y1 = tmp[1] + 1; y1 <= map.length - 1 && map[tmp[0]][y1] != 'X'; y1++){
                if(!visited[tmp[0]][y1]) {
                    queue.offer(new int[] { tmp[0], y1, tmp[2] + 1 });
                    visited[tmp[0]][y1] = true;
                }
            }

            for(int y2 = tmp[1] - 1; y2 >= 0 && map[tmp[0]][y2] != 'X'; y2--) {
                if(!visited[tmp[0]][y2]) {
                    queue.offer(new int[] { tmp[0], y2, tmp[2] + 1 });
                    visited[tmp[0]][y2] = true;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        System.out.println(minimumMoves(
            new String[] { ".X.", ".X.", "..." }, 0, 0, 0, 2
        ));
        System.out.println(minimumMoves(
            new String[] { "...", ".X.", "..." }, 0, 0, 1, 2
        ));
        System.out.println(minimumMoves(
            new String[] { "..X..", "..XX.", "...X.", "...X.", "....." }, 0, 3, 0, 0
        ));
    }
}
