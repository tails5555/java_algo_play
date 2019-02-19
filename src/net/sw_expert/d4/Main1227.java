package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// SW Expert D4 미로1~2 문제 풀이
public class Main1227 {
    static final int[] dr = { 1, 0, -1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 10; k++) {
            int test = Integer.parseInt(br.readLine());
            char[][] maze = new char[100][100];
            int[] start = new int[] { 0, 0 };
            int[] end = new int[] { 0, 0 };
            for(int l = 0; l < 100; l++){
                maze[l] = br.readLine().toCharArray();
                for(int m = 0; m < 100; m++){
                    if(maze[l][m] == '2'){
                        start = new int[] { l, m };
                    }
                    if(maze[l][m] == '3'){
                        end = new int[] { l, m };
                    }
                }
            }

            boolean validate = false;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(start);
            maze[start[0]][start[1]] = '1';
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                if(Arrays.equals(end, cur)) {
                    validate = true;
                    break;
                }
                for(int l = 0; l < dr.length; l++){
                    int tr = cur[0] + dr[l];
                    int tc = cur[1] + dc[l];
                    if((tr >= 0 && tr < 100) && (tc >= 0 && tc < 100)){
                        if(maze[tr][tc] != '1'){
                            maze[tr][tc] = '1';
                            queue.offer(new int[] { tr, tc });
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", test, validate ? 1 : 0);
        }
    }
}
